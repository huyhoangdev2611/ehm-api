package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data

public class Description {
    @JsonProperty("text")
    private String text;
    @JsonProperty("language")
    private Language language;
    @JsonProperty("description_type")
    private DescriptionType descriptionType;
    @JsonProperty("source_ref")
    private String sourceRef;
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
}
