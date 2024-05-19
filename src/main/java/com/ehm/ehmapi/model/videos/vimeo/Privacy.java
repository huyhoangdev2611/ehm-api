package com.ehm.ehmapi.model.videos.vimeo;

import lombok.Data;

@Data

public class Privacy {
    private String view;
    private String embed;
    private Boolean download;
    private Boolean add;
    private String comments;
}
