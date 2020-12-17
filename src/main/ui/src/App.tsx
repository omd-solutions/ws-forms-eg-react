import React, {useState} from 'react';
import {AppBar, Button, Toolbar, Typography} from "@material-ui/core";
import {EntityForm} from "ws-forms-react";
import {Alert} from "@material-ui/lab";

function App() {

    const [employee, setEmployee] = useState({});
    const [updated, setUpdated] = useState(false);
    const [formError, setFormError] = useState(false);

    const handleEntityChange = (updatedEmployee: any, error: boolean) => {
        setEmployee(updatedEmployee);
        if(!error) {
            setFormError(false);
            setUpdated(true);
        } else {
            setFormError(true);
        }
    };

    const fetchEmployee = (employeeId: number) => {
        fetch("/api/employee?id=" + employeeId)
            .then(data => data.json())
            .then(json => {
                setEmployee(json);
                setUpdated(false);
            });
    };

    const saveEmployee = () => {
        fetch("/api/employee", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(employee)
        }).then(() => setUpdated(false));
    };

    return (
        <div>
            <AppBar position="static">
                <Toolbar>
                    <Typography variant="h6">
                        Forms Demo
                    </Typography>
                    <div style={{flexGrow: 1}} />
                    <Button color="inherit"
                            onClick={() => fetchEmployee(1)}>
                        Load Employee 1
                    </Button>
                    <Button color="inherit"
                            onClick={() => fetchEmployee(2)}>
                        Load Employee 2
                    </Button>
                    <Button color="inherit"
                            onClick={() => fetchEmployee(3)}>
                        Load Employee 3
                    </Button>
                    <Button color="inherit" disabled={!updated || formError}
                            onClick={saveEmployee}>
                        Save
                    </Button>
                </Toolbar>
            </AppBar>
            {formError ? (
                <Alert severity="error">There are errors on the form</Alert>
            ) : null}
            <EntityForm entity="com.omd.ws.forms.eg.EmployeeEntity" object={employee} onEntityChange={handleEntityChange} />
        </div>
    );
}

export default App;
