package com.ehm.ehmapi.model.bingimg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class SimilarTerm {
    @JsonProperty("text")

    private String text;

    @JsonProperty("displayText")

    private String displayText;

    @JsonProperty("webSearchUrl")


    private String webSearchUrl;

    @JsonProperty("thumbnail")

    private Thumbnail thumbnail;
}
