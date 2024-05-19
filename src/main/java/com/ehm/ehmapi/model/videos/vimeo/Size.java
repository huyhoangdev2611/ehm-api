package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Size {
    private Integer width;
    private Integer height;
    private String link;
    @JsonProperty("link_with_play_button")
    private String linkWithPlayButton;
}
