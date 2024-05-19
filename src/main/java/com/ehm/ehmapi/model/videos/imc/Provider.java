package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Provider {
    @JsonProperty("name")
    private String name;
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("scheme")
    private Scheme scheme;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("fax")
    private String fax;
    @JsonProperty("website")
    private String website;
    @JsonProperty("email")
    private String email;
    @JsonProperty("city")
    private String city;
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
}
