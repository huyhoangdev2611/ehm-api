package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.result.Publication;
import com.ehm.ehmapi.model.result.SearchResult;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.v1.Customsearch;
import com.google.api.services.customsearch.v1.model.Result;
import com.google.api.services.customsearch.v1.model.Search;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.*;
@Service
@Slf4j
@AllArgsConstructor
public class GoogleService {
    @Value("${application.googleGcseApikey}")
    private static String GCSE_API_KEY;
    @Value("${application.googleGcseSearchEngineId}")
    private static String GCSE_SEARCH_ENGINE_ID;

    public SearchResult getGoogleResults(String placeName, Integer start, Integer count) {
        try {
            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

            Customsearch customsearch = new Customsearch.Builder(httpTransport, jsonFactory, null)
                    .setGoogleClientRequestInitializer(request -> request.setDisableGZipContent(true))
                    .setApplicationName("EHM Search")
                    .build();

            Customsearch.Cse.List list = customsearch.cse().list();
            list.setKey(GCSE_API_KEY);
            list.setCx(GCSE_SEARCH_ENGINE_ID);
            list.setQ(placeName);
            list.setNum(count);
            list.setStart(Long.valueOf(start));
            List<Publication> apiResults = new ArrayList<>();
            Search results = list.execute();
            List<Result> items = results.getItems();
            Integer total = Integer.valueOf(results.getSearchInformation().getTotalResults());

            if (items != null) {
                for (int k = 0; k < items.size() ; k++) {
                    Result data = items.get(k);
                    String title = data.getTitle();
                    String url = data.getLink();
                    String creator = "";
                    String desc = data.getSnippet();
                    String img = "";
                    if (data.getPagemap() != null && data.getPagemap().get("cse_thumbnail") != null) {
                        List<Map<String, Object>> cseThumbnails = (List<Map<String, Object>>) data.getPagemap().get("cse_thumbnail");
                        if (cseThumbnails.size() > 0) {
                            img = (String) cseThumbnails.get(0).get("src");
                        }
                    }
                    String source = data.getDisplayLink();
                    Publication publication = Publication.builder()
                            .title(title)
                            .author(creator)
                            .desc(desc)
                            .url(url)
                            .img(img)
                            .source(source)
                            .build();

                    apiResults.add(publication);
                }
            }
            return SearchResult.builder()
                    .items(apiResults)
                    .total(total)
                    .more(start + count < total)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SearchResult.builder()
                .items(new ArrayList<>())
                .total(0)
                .more(false)
                .build();

    }

}
