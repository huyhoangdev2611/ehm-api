package com.ehm.ehmapi.model.scopus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Value{
    @JsonProperty("$")

    private String value;
}