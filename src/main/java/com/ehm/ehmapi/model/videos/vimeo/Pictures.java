package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data

public class Pictures {
    private String uri;
    private Boolean active;
    private String type;
    @JsonProperty("base_link")
    private String baseLink;
    private List<Size> sizes;
    @JsonProperty("resource_key")
    private String resourceKey;
    @JsonProperty("default_picture")
    private Boolean defaultPicture;
    private List<String> options;
    private Integer total;
}
