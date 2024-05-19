package com.ehm.ehmapi.model.taf;

import lombok.Data;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
@Data
public class Author{
    private String firstName;
    private String lastName;
}


