package com.ehm.ehmapi.model.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Video implements Item, Serializable {
    private String title;
    private String author;
    private String url;
    private String desc;
    private String img;
    private String source;
}
