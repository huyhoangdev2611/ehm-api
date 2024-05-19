package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Badges {
    private Boolean hdr;
    private Live live;
    @JsonProperty("staff_pick")
    private StaffPick staffPick;
    private Boolean vod;
    @JsonProperty("weekend_challenge")
    private Boolean weekendChallenge;
}
