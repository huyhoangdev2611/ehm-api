package com.ehm.ehmapi.model.videos.vimeo;

import lombok.Data;

@Data

public class Paging {
    private String next;
    private String previous;
    private String first;
    private String last;
}
