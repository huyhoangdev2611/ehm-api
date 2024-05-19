package com.ehm.ehmapi.model.bingimg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class QueryContext {
    @JsonProperty("originalQuery")
    private String originalQuery;

    @JsonProperty("alterationDisplayQuery")

    private String alterationDisplayQuery;

    @JsonProperty("alterationOverrideQuery")
    private String alterationOverrideQuery;

    @JsonProperty("alterationMethod")

    private String alterationMethod;

    @JsonProperty("alterationType")

    private String alterationType;
}
