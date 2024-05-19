package com.ehm.ehmapi.model.bingimg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Instrumentation {
    @JsonProperty("_type")
    private String type;
}
