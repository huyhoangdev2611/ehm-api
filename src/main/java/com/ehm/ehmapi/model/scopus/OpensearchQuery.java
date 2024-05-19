package com.ehm.ehmapi.model.scopus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpensearchQuery{
    @JsonProperty("@role")
    private String role;
    @JsonProperty("@searchTerms")
    private String searchTerms;
    @JsonProperty("@startPage")
    private String startPage;
}