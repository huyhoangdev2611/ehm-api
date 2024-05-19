package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Title {
    @JsonProperty("text")
    private String text;
    @JsonProperty("language")
    private Language language;
    @JsonProperty("part_designations")
    private Object partDesignations;
    @JsonProperty("relation")
    private Object relation;
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
}

