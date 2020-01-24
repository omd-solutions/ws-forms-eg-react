package com.omd.ws.forms.eg;

import com.omd.ws.forms.EntityConfigurationException;
import com.omd.ws.forms.FormsService;
import com.omd.ws.forms.WsFormsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(value = {WsFormsConfiguration.class})
public class Application {

    private final FormsService formsService;

    public Application(FormsService formsService) {
        this.formsService = formsService;
    }

    @PostConstruct
    public void init() {
        try {
            formsService.registerEntityForm(EmployeeEntity.class);
        } catch (EntityConfigurationException e) {
            throw new RuntimeException(String.format("Error registering %s", EmployeeEntity.class.getName()), e);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
