package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Tag {
    private String uri;
    private String name;
    private String tag;
    private String canonical;
    private Metadata metadata;
    @JsonProperty("resource_key")
    private String resourceKey;
}
