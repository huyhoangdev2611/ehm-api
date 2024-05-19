package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Connections {
    private Videos videos;
    private Comments comments;
    private Credits credits;
    private Likes likes;
    private Pictures pictures;
    private Texttracks texttracks;
    private Related related;
    private Recommendations recommendations;
    private Ondemand ondemand;
    private Trailer trailer;
    private Season season;
    private Albums albums;
    private Appearances appearances;
    private Channels channels;
    private Feed feed;
    private Followers followers;
    private Following following;
    private Groups groups;
    private Membership membership;
    @JsonProperty("moderated_channels")
    private ModeratedChannels moderatedChannels;
    private Portfolios portfolios;
    private Shared shared;
    @JsonProperty("folders_root")
    private FoldersRoot foldersRoot;
    private Teams teams;
    @JsonProperty("permission_policies")
    private PermissionPolicies permissionPolicies;
}
