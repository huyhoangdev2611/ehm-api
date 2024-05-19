package com.ehm.ehmapi.model.videos.youtube;

import lombok.Data;

@Data

public class Item {
    private String kind;
    private String etag;
    private Id id;
    private Snippet snippet;

}
