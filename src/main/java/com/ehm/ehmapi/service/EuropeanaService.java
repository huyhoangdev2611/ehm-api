package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.europeana.Item;
import com.ehm.ehmapi.model.europeana.EuropeanaResult;
import com.ehm.ehmapi.model.result.Publication;
import com.ehm.ehmapi.model.result.SearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EuropeanaService {
    @Value("${application.europeanaWskey}")
    private String europeanaWskey;

    public SearchResult getEuropeanaResults(String keyword, int start, int count) {
        try {
            String url = UriComponentsBuilder.fromUriString("https://api.europeana.eu/api/v2/search.json")
                    .queryParam("query", keyword)
                    .queryParam("rows", count)
                    .queryParam("start", start)
                    .queryParam("wskey", europeanaWskey)
                    .build().toString();

            HttpEntity<?> entity = new HttpEntity<>(null);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<EuropeanaResult> response = restTemplate.exchange(url, HttpMethod.GET, entity, EuropeanaResult.class);

            EuropeanaResult europeanaResult = response.getBody();
            if (europeanaResult != null) {
                List<Item> items = europeanaResult.getItems();
                Integer total = europeanaResult.getTotalResults();
                List<Publication> apiResults = new ArrayList<>();

                for (Item item : items) {
                    String title = "";
                    String creator = "";
                    if (item.getDcCreator() != null) {
                        creator = item.getDcCreator().get(0);
                        String[] creatorArray = creator.split(", ");
                        List<String> creatorList = Arrays.asList(creatorArray);
                        Collections.reverse(creatorList);
                        String reversedCreator = String.join(" ", creatorList);
                        title = item.getTitle().get(0) + " | " + reversedCreator;
                    } else {
                        title = item.getTitle().get(0);
                    }

                    String postUrl = item.getGuid();

                    String desc = "";
                    if (item.getDcDescription() != null && !item.getDcDescription().isEmpty()) {
                        desc = String.join("; ", item.getDcDescription());
                    }

                    String provider = "";
                    if (item.getDataProvider() != null && !item.getDataProvider().isEmpty()) {
                        provider = item.getDataProvider().get(0);
                    }

                    String img = null;
                    if (item.getEdmPreview() != null && !item.getEdmPreview().isEmpty()) {
                        img = item.getEdmPreview().get(0);
                    }
                    Publication publication = Publication.builder()
                            .title(title)
                            .url(postUrl)
                            .desc(desc)
                            .author(provider)
                            .img(img)
                            .source("Europeana")
                            .sourceImg("europeana_logo_40px.png")
                            .build();

                    apiResults.add(publication);
                }

                return SearchResult.builder()
                        .items(apiResults)
                        .total(total)
                        .more(start + count < total)
                        .build();
            }

            return SearchResult.builder()
                    .items(new ArrayList<>())
                    .total(0)
                    .more(false)
                    .build();
        } catch (Exception e) {
            return SearchResult.builder()
                    .items(new ArrayList<>())
                    .total(0)
                    .more(false)
                    .build();
        }
    }
}
