package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {
    private Connections connections;
    private Integereractions Integereractions;
    @JsonProperty("is_vimeo_create")
    private Boolean isVimeoCreate;
    @JsonProperty("is_screen_record")
    private Boolean isScreenRecord;
}
