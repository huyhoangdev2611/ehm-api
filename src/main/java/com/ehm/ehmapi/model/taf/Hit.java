package com.ehm.ehmapi.model.taf;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Hit {
    private Document document;
    private List<Concept> concepts;
}
