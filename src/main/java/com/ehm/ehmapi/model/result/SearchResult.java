package com.ehm.ehmapi.model.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult implements Serializable {
    private List<?> items;
    private Integer total;
    private Boolean more;
    private String nextPageToken;
}
