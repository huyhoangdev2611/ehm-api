package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data

public class ImcResults {
    @JsonProperty("data")
    private List<ImcData> data;
    @JsonProperty("meta")
    private Meta meta;
}
