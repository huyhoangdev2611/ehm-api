package com.ehm.ehmapi.model.gallica;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "dc", namespace = "http://www.openarchives.org/OAI/2.0/oai_dc/")
public class DC {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> relation;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> rights;
    private String source;
    private String title;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> type;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> creator;
    private String date;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> description;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> format;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> identifier;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> contributor;
}
