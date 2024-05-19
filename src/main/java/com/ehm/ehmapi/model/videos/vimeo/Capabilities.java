package com.ehm.ehmapi.model.videos.vimeo;

import lombok.Data;

@Data

public class Capabilities {
    private Boolean hasLiveSubscription;
    private Boolean hasEnterpriseLihp;
    private Boolean hasSvvTimecodedComments;
    private Boolean hasSimplifiedEnterpriseAccount;
}
