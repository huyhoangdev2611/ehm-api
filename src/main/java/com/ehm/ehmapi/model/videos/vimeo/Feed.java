package com.ehm.ehmapi.model.videos.vimeo;

import lombok.Data;

import java.util.List;
@Data

public class Feed {
    private String uri;
    private List<String> options;
}
