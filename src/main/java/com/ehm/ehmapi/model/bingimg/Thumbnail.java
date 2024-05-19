package com.ehm.ehmapi.model.bingimg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Thumbnail {
    @JsonProperty("width")
    private Integer width;

    @JsonProperty("height")

    private Integer height;

    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;

    @JsonProperty("url")

    private String url;
}
