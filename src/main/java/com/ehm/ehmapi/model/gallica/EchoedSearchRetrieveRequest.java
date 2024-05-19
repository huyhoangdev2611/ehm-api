package com.ehm.ehmapi.model.gallica;

import lombok.Data;

@Data
public class EchoedSearchRetrieveRequest {
    private String query;
    private String version;
}
