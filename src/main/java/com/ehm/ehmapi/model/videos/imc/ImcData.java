package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data

public class ImcData {
    @JsonProperty("date_created")
    private List<String> dateCreated;
    @JsonProperty("date_issued")
    private String dateIssued;
    @JsonProperty("non_av_type")
    private NonAvType nonAvType;
    @JsonProperty("specific_type")
    private SpecificType specificType;
    @JsonProperty("phisical_format_size")
    private List<String> physicalFormatSize;
    @JsonProperty("colour")
    private String colour;
    @JsonProperty("external_ids")
    private List<String> externalIds;
    @JsonProperty("rights_status")
    private RightsStatus rightsStatus;
    @JsonProperty("collection_title")
    private String collectionTitle;
    @JsonProperty("id")
    private String id;
    @JsonProperty("_record_sources")
    private List<RecordSource> recordSources;
    @JsonProperty("_titles")
    private List<Title> titles;
    @JsonProperty("_keywords")
    private List<Keyword> keywords;
    @JsonProperty("_descriptions")
    private List<Description> descriptions;
    @JsonProperty("_contributors")
    private List<Contributor> contributors;
    @JsonProperty("_item")
    private List<Item> items;
    @JsonProperty("type")
    private String type;
    @JsonProperty("links")
    private Links links;
    @JsonProperty("_rightholders")
    private List<Rightholder> rightholders;
}
