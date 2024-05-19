package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class LocationDetails {
    @JsonProperty("formatted_address")
    private String formattedAddress;
    private Double latitude;
    private Double longitude;
    private String city;
    private String state;
    private Object neighborhood;
    @JsonProperty("sub_locality")
    private Object subLocality;
    @JsonProperty("state_iso_code")
    private String stateIsoCode;
    private String country;
    @JsonProperty("country_iso_code")
    private String countryIsoCode;
}
