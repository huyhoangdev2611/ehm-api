package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Keyword {
    @JsonProperty("term")
    private String term;
    @JsonProperty("termID")
    private Object termID;
    @JsonProperty("keyword_type")
    private KeywordType keywordType;
    @JsonProperty("language")
    private Language language;
    @JsonProperty("schemeID")
    private Object schemeID;
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
}
