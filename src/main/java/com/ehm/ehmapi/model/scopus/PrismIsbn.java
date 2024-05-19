package com.ehm.ehmapi.model.scopus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PrismIsbn{
    @JsonProperty("@_fa")
    private String fa;
    @JsonProperty("$")
    private String value;
}