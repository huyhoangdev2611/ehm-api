package com.ehm.ehmapi.model.europeana;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Item{
    private Integer completeness;
    private List<String> country;
    private List<String> dataProvider;
    private List<String> dcCreator;
    private DcCreatorLangAware dcCreatorLangAware;
    private List<String> dcDescription;
    private DcDescriptionLangAware dcDescriptionLangAware;
    private List<String> dcLanguage;
    private DcLanguageLangAware dcLanguageLangAware;
    private DcTitleLangAware dcTitleLangAware;
    private List<String> edmConcept;
    private List<EdmConceptLabel> edmConceptLabel;
    private EdmConceptPrefLabelLangAware edmConceptPrefLabelLangAware;
    private List<String> edmDatasetName;
    private List<String> edmIsShownAt;
    private List<EdmPlaceLabel> edmPlaceLabel;
    private EdmPlaceLabelLangAware edmPlaceLabelLangAware;
    private List<String> edmPreview;
    private List<EdmTimespanLabel> edmTimespanLabel;
    private EdmTimespanLabelLangAware edmTimespanLabelLangAware;
    private List<String> europeanaCollectionName;
    private Integer europeanaCompleteness;
    private String guid;
    private String id;
    private Integer index;
    private List<String> language;
    private String link;
    private Boolean previewNoDistribute;
    private List<String> provider;
    private List<String> rights;
    private Double score;
    private Long timestamp;
    @JsonProperty("timestamp_created")
    private Date timestampCreated;
    @JsonProperty("timestamp_created_epoch")
    private Long timestampCreatedEpoch;
    @JsonProperty("timestamp_update")
    private Date timestampUpdate;
    @JsonProperty("timestamp_update_epoch")
    private Long timestampUpdateEpoch;
    private List<String> title;
    private String type;
    private List<Boolean> ugc;
    private List<String> year;
    private List<String> edmIsShownBy;
}
