package com.ehm.ehmapi.model.scopus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Link{
    @JsonProperty("@_fa")
    private String fa;
    @JsonProperty("@ref")
    private String ref;
    @JsonProperty("@href")
    private String href;
    @JsonProperty("@type")
    private String type;
}