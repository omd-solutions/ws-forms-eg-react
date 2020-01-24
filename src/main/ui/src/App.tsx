import React, {useState} from 'react';
import {AppBar, Button, Toolbar, Typography} from "@material-ui/core";
import {EntityForm} from "ws-forms-react";

function App() {

    const [employee, setEmployee] = useState({});
    const [updated, setUpdated] = useState(false);

    const handleEntityChange = (updatedEmployee: any) => {
        setEmployee(updatedEmployee);
        setUpdated(true);
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
                    <Button color="inherit" disabled={!updated}
                            onClick={saveEmployee}>
                        Save
                    </Button>
                </Toolbar>
            </AppBar>
            <EntityForm entity="com.omd.ws.forms.eg.EmployeeEntity" object={employee} onEntityChange={handleEntityChange} />
        </div>
    );
};

export default App;
