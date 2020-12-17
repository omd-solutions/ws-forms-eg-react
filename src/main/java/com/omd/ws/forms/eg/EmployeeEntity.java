package com.omd.ws.forms.eg;

import com.omd.ws.forms.*;

@EntityForm(panels = {
        @Panel(name = "personalDetails", caption = "Personal Details", tab = "Basic Details"),
        @Panel(name = "location", caption = "Location", tab = "Basic Details")
})
public class EmployeeEntity {

    @FormsIgnore
    private String id;

    @FormField(columns = 6, panel = "personalDetails")
    private String firstName;

    @FormField(columns = 6, panel = "personalDetails")
    private String lastName;

    @FormField(panel = "personalDetails")
    private String address;

    @FormField(columns = 6, panel = "personalDetails")
    @Text(validationRegex = "0[0-9]{10}", validationMessage = "Must be 11 digits and start with a 0")
    private String phoneNumber;

    @FormField(columns = 6, panel = "personalDetails")
    @Text(masked = true, validationRegex = "^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!#$%&? \"]).*$", validationMessage = "Must be at least 8 characters with at least 1 number, capital and special char")
    private String password;

    @FormField(columns = 6, panel = "location")
    @Select(displayField = "name", valueProvider = CountryValueProvider.class)
    private Country country;

    @FormField(columns = 6, panel = "location")
    @FilteredSelect(valueProvider = RegionValueProvider.class, filteredBy = "country")
    private String region;

    @FormField(columns = 6, panel = "location")
    @FilteredSelect(valueProvider = CityValueProvider.class, filteredBy = "region")
    private String city;

    @FormField(columns = 6, panel = "location")
    @FilteredSelect(valueProvider = LanguageValueProvider.class, filteredBy = "country")
    private String language;

    @FormField(tab = "Resume")
    private String resume;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String id, String firstName, String lastName, String address, Country country, String language) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.language = language;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
