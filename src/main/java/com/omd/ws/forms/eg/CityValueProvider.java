package com.omd.ws.forms.eg;

import com.omd.ws.forms.FilteredSelectValueProvider;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class CityValueProvider implements FilteredSelectValueProvider<String, String> {

    private static final Map<String, List<String>> CITIES_BY_REGION = Map.of(
            "England", List.of("London", "Manchester", "Birmingham"),
            "Wales", List.of("Cardiff", "Newport"),
            "Scotland", List.of("Glasgow", "Edinburgh"),
            "New York", List.of("New York City"),
            "California", List.of("Los Angeles"),
            "Riviera", List.of("Monaco"),
            "Provence", List.of("Paris")
    );

    @Override
    public List<String> getValues(String filter) {
        return CITIES_BY_REGION.getOrDefault(filter, emptyList());
    }
}
