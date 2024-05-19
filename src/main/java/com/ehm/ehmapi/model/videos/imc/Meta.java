package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Meta {
    @JsonProperty("totalItems")
    private Integer totalItems;
    @JsonProperty("countByProviders")
    private CountByProviders countByProviders;
    @JsonProperty("countByYears")
    private CountByYears countByYears;
}
