package com.ehm.ehmapi.model.scopus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Entry{
    @JsonProperty("@_fa")
    private String fa;
    private List<Link> link;
    @JsonProperty("prism:url")
    private String prismUrl;
    @JsonProperty("dc:identifier")
    private String dcIdentifier;
    private String eid;

    @JsonProperty("dc:title")
    private String dcTitle;
    @JsonProperty("dc:creator")
    private String dcCreator;
    @JsonProperty("prism:publicationName")
    private String prismPublicationName;
    @JsonProperty("prism:issn")
    private String prismIssn;
    @JsonProperty("prism:eIssn")
    private String prismEIssn;
    @JsonProperty("prism:volume")
    private String prismVolume;
    @JsonProperty("prism:issueIdentifier")
    private String prismIssueIdentifier;
    @JsonProperty("prismPageRange")
    private String prismPageRange;
    @JsonProperty("prism:coverDate")
    private String prismCoverDate;
    @JsonProperty("prism:coverDisplayDate")
    private String prismCoverDisplayDate;
    @JsonProperty("prism:doi")
    private String prismDoi;
    @JsonProperty("pii")
    private String pii;
    @JsonProperty("citedby-count")
    private String citedbyCount;
    private List<Affiliation> affiliation;
    @JsonProperty("prism:aggregationType")
    private String prismAggregationType;
    private String subtype;
    private String subtypeDescription;
    @JsonProperty("source-id")
    private String sourceId;
    private String openaccess;
    private boolean openaccessFlag;
    private Freetoread freetoread;
    private FreetoreadLabel freetoreadLabel;
    @JsonProperty("prism:isbn")
    private List<PrismIsbn> prismIsbn;
}