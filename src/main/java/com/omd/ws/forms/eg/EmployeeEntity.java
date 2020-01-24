package com.omd.ws.forms.eg;

import com.omd.ws.forms.*;

@EntityForm(sections = {
        @Section(name = "personalDetails", caption = "Personal Details")
})
public class EmployeeEntity {

    @FormsIgnore
    private String id;
    @FormField(columns = 6, section = "personalDetails")
    private String firstName;
    @FormField(columns = 6, section = "personalDetails")
    private String lastName;
    @FormField(section = "personalDetails")
    private String address;
    @FormField(columns = 6, section = "personalDetails")
    @Select(displayField = "name", valueProvider = CountryValueProvider.class)
    private Country country;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String id, String firstName, String lastName, String address, Country country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
