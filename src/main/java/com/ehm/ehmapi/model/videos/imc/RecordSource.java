package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data

public class RecordSource {
    @JsonProperty("source_id")
    private String sourceId;
    @JsonProperty("is_shown_at")
    private Object isShownAt;
    @JsonProperty("id")
    private String id;
    @JsonProperty("_provider")
    private List<Provider> provider;
    @JsonProperty("type")
    private String type;
}
