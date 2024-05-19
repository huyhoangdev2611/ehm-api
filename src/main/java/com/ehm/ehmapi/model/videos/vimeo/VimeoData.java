package com.ehm.ehmapi.model.videos.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data

public class VimeoData {
    private String uri;
    private String name;
    private String description;
    private String type;
    private String link;
    @JsonProperty("player_embed_url")
    private String playerEmbedUrl;
    private Integer duration;
    private Integer width;
    private String language;
    private Integer height;
    private Embed embed;
    @JsonProperty("created_time")
    private Date createdTime;
    @JsonProperty("modified_time")
    private Date modifiedTime;
    @JsonProperty("release_time")
    private Date releaseTime;
    @JsonProperty("content_rating")
    private List<String> contentRating;
    @JsonProperty("content_rating_class")
    private String contentRatingClass;
    @JsonProperty("rating_mod_locked")
    private Boolean ratingModLocked;
    private String license;
    private Privacy privacy;
    private Pictures pictures;
    private List<Tag> tags;
    private Stats stats;
    private List<Object> categories;
    private Uploader uploader;
    private Metadata metadata;
    private User user;
    private Object app;
    private Play play;
    private String status;
    @JsonProperty("resource_key")
    private String resourcekey;
    private Object upload;
    private Object transcode;
    @JsonProperty("is_playable")
    private Boolean isPlayable;
    @JsonProperty("has_audio")
    private Boolean hasAudio;
    private Vod vod;
}
