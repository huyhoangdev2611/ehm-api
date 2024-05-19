package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data

public class User {
    private String uri;
    private String name;
    private String link;
    private Capabilities capabilities;
    private String location;
    private String gender;
    private String bio;
    @JsonProperty("short_bio")
    private String shortBio;
    @JsonProperty("created_time")
    private Date createdTime;
    private Pictures pictures;
    private List<Website> websites;
    private Metadata metadata;
    @JsonProperty("location_details")
    private LocationDetails locationDetails;
    private List<Skill> skills;
    @JsonProperty("available_for_hire")
    private Boolean availableForHire;
    @JsonProperty("can_work_remotely")
    private Boolean canWorkRemotely;
    @JsonProperty("resource_key")
    private String resourceKey;
    private String account;
}
