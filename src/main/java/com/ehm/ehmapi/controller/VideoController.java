package com.ehm.ehmapi.controller;

import com.ehm.ehmapi.model.result.SearchResult;
import com.ehm.ehmapi.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/videos"})
class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchResult listVideos(@RequestParam("query") String keyword, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "pageToken", defaultValue = "") String pageToken) {
        return videoService.getVideo(keyword, page, 6, pageToken);
    }


}
