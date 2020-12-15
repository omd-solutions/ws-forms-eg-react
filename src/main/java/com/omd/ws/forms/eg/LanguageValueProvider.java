package com.omd.ws.forms.eg;

import com.omd.ws.forms.FilteredSelectValueProvider;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class LanguageValueProvider implements FilteredSelectValueProvider<String, Country> {

    private static final Map<String, List<String>> LANGS_BY_COUNTRY = Map.of(
            "uk", List.of("English", "Welsh"),
            "us", List.of("English", "Redneck"),
            "france", List.of("French")
    );

    @Override
    public List<String> getValues(Country filter) {
        return LANGS_BY_COUNTRY.getOrDefault(filter.getId(), emptyList());
    }
}
