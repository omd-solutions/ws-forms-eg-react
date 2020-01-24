import React from 'react';
import {AppBar, Toolbar, Typography} from "@material-ui/core";
import {EntityForm} from "ws-forms-react";

const App: React.FC = () => {
    return (
        <div>
            <AppBar position="static">
                <Toolbar>
                    <Typography variant="h6">
                        Forms Demo
                    </Typography>
                    <div style={{flexGrow: 1}} />
                </Toolbar>
            </AppBar>
            <EntityForm entity="com.omd.ws.forms.eg.EmployeeEntity" object={{}} onEntityChange={() => {}} />
        </div>
    );
};

export default App;
