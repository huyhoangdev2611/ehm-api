package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Links {
    @JsonProperty("content")
    private String content;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("summary")
    private String summary;
}
