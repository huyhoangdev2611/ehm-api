package com.ehm.ehmapi.model.videos.vimeo;

import lombok.Data;

import java.util.List;
@Data

public class Report {
    private String uri;
    private List<String> options;
    private List<String> reason;
}
