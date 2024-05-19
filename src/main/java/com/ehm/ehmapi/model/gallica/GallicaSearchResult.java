package com.ehm.ehmapi.model.gallica;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@ToString
@XmlRootElement(name = "searchRetrieveResponse", namespace = "http://www.loc.gov/zing/srw/")

public class GallicaSearchResult {
    private String version;
    private EchoedSearchRetrieveRequest echoedSearchRetrieveRequest;
    private Integer numberOfRecords;
    private String extraResponseData;
    @XmlElement(name = "record")
    private List<Record> records;
    private Integer nextRecordPosition;
    private String ns6;
    private String diag;
    @JsonProperty("oai_dc")
    private String oaiDc;
    private String srw;
    private String dc;
    private String text;


}
