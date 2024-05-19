package com.ehm.ehmapi.model.gallica;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Record {

    private String recordSchema;
    private String recordPacking;
    private RecordData recordData;
    private String recordIdentifier;
    private Integer recordPosition;
    private ExtraRecordData extraRecordData;

}
