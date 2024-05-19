package com.ehm.ehmapi.model.taf;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
@Data
public class TAFResults {
    private List<Hit> hits;
    private Integer totalHits;
}
