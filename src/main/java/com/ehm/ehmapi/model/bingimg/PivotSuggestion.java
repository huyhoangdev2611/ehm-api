package com.ehm.ehmapi.model.bingimg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data

public class PivotSuggestion {
    @JsonProperty("pivot")
    private String pivot;

    @JsonProperty("suggestions")
    private List<RelatedSearch> suggestions;
}
