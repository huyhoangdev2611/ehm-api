package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data

public class Ondemand {
    private String uri;
    private List<String> options;
    @JsonProperty("resource_key")
    private String resourceKey;
}
