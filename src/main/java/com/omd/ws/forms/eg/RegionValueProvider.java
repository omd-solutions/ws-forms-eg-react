package com.omd.ws.forms.eg;

import com.omd.ws.forms.FilteredSelectValueProvider;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class RegionValueProvider implements FilteredSelectValueProvider<String, Country> {

    private static final Map<String, List<String>> REGIONS_BY_COUNTRY = Map.of(
            "uk", List.of("England", "Wales", "Scotland"),
            "us", List.of("New York", "California"),
            "france", List.of("Riviera", "Provence")
    );

    @Override
    public List<String> getValues(Country filter) {
        return REGIONS_BY_COUNTRY.getOrDefault(filter.getId(), emptyList());
    }
}
