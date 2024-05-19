package com.ehm.ehmapi.model.bingimg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InsightsMetadata {
    @JsonProperty("recipeSourcesCount")
    private Integer recipeSourcesCount;

    @JsonProperty("pagesIncludingCount")
    private Integer pagesIncludingCount;

    @JsonProperty("availableSizesCount")
    private Integer availableSizesCount;
}
