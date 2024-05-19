package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StaffPick {
    private Boolean normal;
    @JsonProperty("best_of_the_month")
    private Boolean bestOfTheMonth;
    @JsonProperty("best_of_the_year")
    private Boolean bestOfTheYear;
    private Boolean premiere;
}
