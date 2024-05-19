package com.ehm.ehmapi.model.scopus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScopusResult {
    @JsonProperty("search-results")
    private SearchResults searchResults;

}









