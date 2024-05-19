package com.ehm.ehmapi.model.scopus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Affiliation{
    @JsonProperty("@_fa")
    private String fa;
    private String affilname;
    @JsonProperty("affiliation-city")
    private String affiliationCity;
    @JsonProperty("affiliation-country")
    private String affiliationCountry;
}