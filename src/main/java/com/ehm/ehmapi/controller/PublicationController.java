package com.ehm.ehmapi.controller;

import com.ehm.ehmapi.model.result.SearchResult;
import com.ehm.ehmapi.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/publications"})
class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchResult listPublications(@RequestParam("query") String keyword, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        return publicationService.getPublications(keyword, page, 5);
    }


}