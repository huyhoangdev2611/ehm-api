package com.ehm.ehmapi.model.taf;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Document {
    private String id;
    private String doi;
    private String title;
    private String journal;
    private String publicationDate;
    private String abstractText;
    private List<Author> authors;
    private Double score;
    private CustomFields customFields;
}
