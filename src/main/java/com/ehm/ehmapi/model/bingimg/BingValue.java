package com.ehm.ehmapi.model.bingimg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BingValue {
    @JsonProperty("webSearchUrl")
    private String webSearchUrl;

    @JsonProperty("name")
    private String name;

    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;

    @JsonProperty("datePublished")
    private Date datePublished;

    @JsonProperty("isFamilyFriendly")
    private Boolean isFamilyFriendly;

    @JsonProperty("creativeCommons")
    private String creativeCommons;

    @JsonProperty("contentUrl")
    private String contentUrl;

    @JsonProperty("hostPageUrl")
    private String hostPageUrl;

    @JsonProperty("contentSize")
    private String contentSize;

    @JsonProperty("encodingFormat")
    private String encodingFormat;

    @JsonProperty("hostPageDisplayUrl")
    private String hostPageDisplayUrl;

    @JsonProperty("width")
    private Integer width;

    @JsonProperty("height")
    private Integer height;

    @JsonProperty("hostPageFavIconUrl")
    private String hostPageFavIconUrl;

    @JsonProperty("hostPageDiscoveredDate")
    private Date hostPageDiscoveredDate;

    @JsonProperty("thumbnail")
    private Thumbnail thumbnail;

    @JsonProperty("imageInsightsToken")
    private String imageInsightsToken;

    @JsonProperty("insightsMetadata")
    private InsightsMetadata insightsMetadata;

    @JsonProperty("imageId")
    private String imageId;

    @JsonProperty("accentColor")
    private String accentColor;

    @JsonProperty("proxyContentUrl")
    private String proxyContentUrl;

    @JsonProperty("hostPageDomainFriendlyName")
    private String hostPageDomainFriendlyName;
}
