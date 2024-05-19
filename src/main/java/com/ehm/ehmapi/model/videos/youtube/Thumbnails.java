package com.ehm.ehmapi.model.videos.youtube;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Thumbnails {
    @JsonProperty("default")
    private Default mydefault;
    private Medium medium;
    private High high;

}

