package com.ehm.ehmapi.model.scopus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SearchResults{
    @JsonProperty("opensearch:totalResults")
    private Integer opensearchTotalResults;
    @JsonProperty("opensearch:startIndex")
    private Integer opensearchStartIndex;
    @JsonProperty("opensearch:itemsPerPage")
    private Integer opensearchItemsPerPage;
    @JsonProperty("opensearch:Query")
    private OpensearchQuery opensearchQuery;

    private List<Link> link;
    private List<Entry> entry;
}