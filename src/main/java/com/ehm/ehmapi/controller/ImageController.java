package com.ehm.ehmapi.controller;

import com.ehm.ehmapi.model.result.SearchResult;
import com.ehm.ehmapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/images"})
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchResult listImages(@RequestParam("query") String keyword, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        return imageService.getImages(keyword, page, 5);
    }
}
