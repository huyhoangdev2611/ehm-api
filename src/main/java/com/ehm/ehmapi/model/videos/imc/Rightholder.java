package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Rightholder {
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private Object url;
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
}
