package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data

public class Item {
    @JsonProperty("duration")
    private Object duration;
    @JsonProperty("dimension")
    private Long dimension;
    @JsonProperty("framerate")
    private Object framerate;
    @JsonProperty("digital_format")
    private List<String> digitalFormat;
    @JsonProperty("item_type")
    private ItemType itemType;
    @JsonProperty("public_access")
    private Boolean publicAccess;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("modified")
    private Date modified;
    @JsonProperty("id")
    private String id;
    @JsonProperty("_ownership")
    private List<Ownership> ownership;
    @JsonProperty("type")
    private String type;
}
