package com.ehm.ehmapi.model.europeana;

import lombok.Data;

import java.util.List;
@Data
public class DcTitleLangAware{
    private List<String> def;
    private List<String> en;
    private List<String> de;
}