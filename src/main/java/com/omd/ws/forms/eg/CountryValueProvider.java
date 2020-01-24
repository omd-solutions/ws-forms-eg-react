package com.omd.ws.forms.eg;

import com.omd.ws.forms.SelectValueProvider;

import java.util.List;

public class CountryValueProvider implements SelectValueProvider<Country> {

    @Override
    public List<Country> getValues() {
        return List.of(new Country("uk", "United Kingdom"),
                new Country("us", "United States"),
                new Country("france", "France"));
    }
}
