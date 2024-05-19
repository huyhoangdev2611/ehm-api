package com.ehm.ehmapi.model.videos.vimeo;

import lombok.Data;

import java.util.List;
@Data

public class Season {
    private String uri;
    private List<String> options;
    private String name;
}
