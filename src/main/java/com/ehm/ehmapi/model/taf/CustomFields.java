package com.ehm.ehmapi.model.taf;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class CustomFields {
    @JsonProperty("subject-classification")
    private List<SubjectClassification> subjectClassification;
}
