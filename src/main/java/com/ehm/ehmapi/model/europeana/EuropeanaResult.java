package com.ehm.ehmapi.model.europeana;

import lombok.Data;

import java.util.List;

@Data
public class EuropeanaResult {
    private String apikey;
    private Boolean success;
    private Integer requestNumber;
    private Integer itemsCount;
    private Integer totalResults;
    private List<Item> items;
}
