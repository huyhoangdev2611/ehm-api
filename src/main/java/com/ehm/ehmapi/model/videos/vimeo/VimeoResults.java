package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class VimeoResults {
    private Integer total;
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    private Paging paging;
    private List<VimeoData> data;
}
