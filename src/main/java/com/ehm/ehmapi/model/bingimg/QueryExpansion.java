package com.ehm.ehmapi.model.bingimg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class QueryExpansion {
    @JsonProperty("text")

    private String text;

    @JsonProperty("displayText")


    private String displayText;

    @JsonProperty("webSearchUrl")


    private String webSearchUrl;

    @JsonProperty("searchLink")


    private String searchLink;

    @JsonProperty("thumbnail")


    private Thumbnail thumbnail;
}
