package com.omd.ws.forms.eg;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    private Map<String, EmployeeEntity> employees = new HashMap<>();

    public Controller() {
        employees.put("1", new EmployeeEntity("1", "Oliver", "Dennis", "3 Overdale Place", new Country("uk", "United Kingdom"), "English"));
        employees.put("2", new EmployeeEntity("2", "Emily", "Hancock", "Foxdales Farm", new Country("uk", "United Kingdom"), "Welsh"));
        employees.put("3", new EmployeeEntity("3", "Tom", "Smith", "21 Speedwell Drive", null, null));
    }

    @RequestMapping(value = "/api/employee", method = RequestMethod.GET)
    public EmployeeEntity getEmployee(@RequestParam String id) {
        return employees.get(id);
    }

    @RequestMapping(value = "/api/employee", method = RequestMethod.POST)
    public void saveEmployee(@RequestBody EmployeeEntity employee) {
        employees.put(employee.getId(), employee);
    }

}
