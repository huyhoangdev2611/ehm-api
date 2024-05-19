package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountByYears {
    @JsonProperty("-10")
    private Integer minus10;
    @JsonProperty("-190")
    private Integer minus190;
    @JsonProperty("1850")
    private Integer _1850;
    @JsonProperty("1860")
    private Integer _1860;
    @JsonProperty("1870")
    private Integer _1870;
    @JsonProperty("1880")
    private Integer _1880;
    @JsonProperty("1890")
    private Integer _1890;
    @JsonProperty("1900")
    private Integer _1900;
    @JsonProperty("1910")
    private Integer _1910;
    @JsonProperty("1920")
    private Integer _1920;
    @JsonProperty("1930")
    private Integer _1930;
    @JsonProperty("1940")
    private Integer _1940;
    @JsonProperty("1950")
    private Integer _1950;
    @JsonProperty("1960")
    private Integer _1960;
    @JsonProperty("1970")
    private Integer _1970;
    @JsonProperty("1980")
    private Integer _1980;
    @JsonProperty("1990")
    private Integer _1990;
    @JsonProperty("2000")
    private Integer _2000;
    @JsonProperty("2010")
    private Integer _2010;
    @JsonProperty("<190")
    private Integer lessThan190;
    @JsonProperty(">190")
    private Integer greaterThan190;
    @JsonProperty("[190")
    private Integer starting190;
}
