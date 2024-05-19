package com.ehm.ehmapi.model.videos.imc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class CountByProviders {
    @JsonProperty("OFM")
    private Integer oFM;
    @JsonProperty("CCB")
    private Integer cCB;
    @JsonProperty("DFI")
    private Integer dFI;
    @JsonProperty("FDC")
    private Integer fDC;
    @JsonProperty("MNC")
    private Integer mNC;
    @JsonProperty("SFI")
    private Integer sFI;
    @JsonProperty("TTE")
    private Integer tTE;
    @JsonProperty("CRB")
    private Integer cRB;
    @JsonProperty("WSTLA")
    private Integer wSTLA;
    @JsonProperty("DIF")
    private Integer dIF;
}
