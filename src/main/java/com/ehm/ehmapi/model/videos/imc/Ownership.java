package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Ownership {
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
}
