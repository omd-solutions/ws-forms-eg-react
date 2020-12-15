package com.omd.ws.forms.eg;

import com.omd.ws.forms.*;

@EntityForm(sections = {
        @Section(name = "personalDetails", caption = "Personal Details"),
        @Section(name = "location", caption = "Location")
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

    @FormField(columns = 6, section = "location")
    @Select(displayField = "name", valueProvider = CountryValueProvider.class)
    private Country country;

    @FormField(columns = 6, section = "location")
    @FilteredSelect(valueProvider = RegionValueProvider.class, filteredBy = "country")
    private String region;

    @FormField(columns = 6, section = "location")
    @FilteredSelect(valueProvider = CityValueProvider.class, filteredBy = "region")
    private String city;

    @FormField(columns = 6, section = "location")
    @FilteredSelect(valueProvider = LanguageValueProvider.class, filteredBy = "country")
    private String language;

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
}
