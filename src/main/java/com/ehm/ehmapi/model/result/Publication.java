package com.ehm.ehmapi.model.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publication implements Item, Serializable {
    private String title;
    private String url;
    private String doi;
    private String desc;
    private String author;
    private String img;
    private String source;
    private String sourceImg;
}
