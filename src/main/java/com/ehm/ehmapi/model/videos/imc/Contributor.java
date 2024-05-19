package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data

public class Contributor {
    @JsonProperty("external_ids")
    private Long externalIds;
    @JsonProperty("agent_type")
    private AgentType agentType;
    @JsonProperty("names")
    private List<String> names;
    @JsonProperty("birth_date")
    private Date birthDate;
    @JsonProperty("death_date")
    private Date deathDate;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("activities")
    private List<String> activities;
}
