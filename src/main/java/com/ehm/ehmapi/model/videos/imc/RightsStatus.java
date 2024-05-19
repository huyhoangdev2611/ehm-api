package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class RightsStatus {
    @JsonProperty("key")
    private String key;
    @JsonProperty("description")
    private String description;
}
