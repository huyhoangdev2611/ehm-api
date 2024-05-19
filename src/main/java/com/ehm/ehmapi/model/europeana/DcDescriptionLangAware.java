package com.ehm.ehmapi.model.europeana;

import lombok.Data;

import java.util.List;
@Data
public class DcDescriptionLangAware{
    private List<String> def;
    private List<String> en;
    private List<String> fr;
    private List<String> de;
}