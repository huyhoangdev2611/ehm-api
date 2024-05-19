package com.ehm.ehmapi.model.bingimg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BingImgResults {
    @JsonProperty("_type")
    private String type;

    private Instrumentation instrumentation;

    @JsonProperty("readLink")
    private String readLink;

    private String webSearchUrl;

    private QueryContext queryContext;

    private Integer totalEstimatedMatches;

    private Integer nextOffset;

    private Integer currentOffset;

    private List<BingValue> value;

    private List<QueryExpansion> queryExpansions;

    private List<PivotSuggestion> pivotSuggestions;

    private List<SimilarTerm> similarTerms;

    private List<RelatedSearch> relatedSearches;
}
