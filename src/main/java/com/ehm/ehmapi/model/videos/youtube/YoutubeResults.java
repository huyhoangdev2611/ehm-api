package com.ehm.ehmapi.model.videos.youtube;

import lombok.Data;

import java.util.List;
@Data
public class YoutubeResults {
    private String kind;
    private String etag;
    private String nextPageToken;
    private String regionCode;
    private PageInfo pageInfo;
    private List<Item> items;

}
