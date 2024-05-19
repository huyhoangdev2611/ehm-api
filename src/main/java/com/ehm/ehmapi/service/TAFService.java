package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.result.SearchResult;
import com.ehm.ehmapi.model.taf.Author;
import com.ehm.ehmapi.model.taf.Document;
import com.ehm.ehmapi.model.taf.Hit;
import com.ehm.ehmapi.model.taf.TAFResults;
import com.ehm.ehmapi.model.result.Publication;

import org.springframework.beans.factory.annotation.Value;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class TAFService {
    private static final String API_BASE_URL = "https://services.unsilo.com/api/related/v3/tandf-combined/full-text-search";
    @Value("${application.tafUsername}")
    private String tafUsername;
    @Value("${application.tafPassword}")
    private String tafPassword;


    public SearchResult getTAFResults(String placeName, Integer start, Integer count) {
        try {
            placeName = java.net.URLDecoder.decode(placeName, StandardCharsets.UTF_8);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(tafUsername, tafPassword);
            headers.set("accept", "*/*");
            headers.setContentType(MediaType.TEXT_PLAIN);
            HttpEntity<String> requestEntity = new HttpEntity<>("\"" + placeName + "\"", headers);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                    .queryParam("includeAbstract", false)
                    .queryParam("count", count)
                    .queryParam("offset", start);

            String link = builder.toUriString();

            ResponseEntity<TAFResults> responseEntity = restTemplate.exchange(link, HttpMethod.POST, requestEntity, TAFResults.class);

            TAFResults tafResults = responseEntity.getBody();


            if (tafResults != null) {
                List<Publication> apiResults = new ArrayList<>();
                List<Hit> hits = tafResults.getHits();
                int total = tafResults.getTotalHits();

                for (Hit hit : hits) {
                    Document doc = hit.getDocument();
                    String title = doc.getTitle() != null ? doc.getTitle() : doc.getJournal();
                    List<Author> authors = doc.getAuthors();
                    List<String> authorNames = new ArrayList<>();

                    for (Author author : authors) {
                        if (author.getLastName() != null && author.getFirstName() != null) {
                            authorNames.add(author.getLastName() + " " + author.getFirstName());
                        } else if (author.getLastName() != null) {
                            authorNames.add(author.getLastName());
                        } else if (author.getFirstName() != null) {
                            authorNames.add(author.getFirstName());
                        } else {
                            authorNames.add("");
                        }
                    }

                    String authorString = String.join(", ", authorNames);
                    String desc = doc.getJournal();
                    String doi = doc.getDoi();
                    String url = "https://doi.org/" + doi;

                    Publication publication = Publication.builder()
                            .title(title)
                            .author(authorString)
                            .desc(desc)
                            .url(url)
                            .doi(doi)
                            .img("")
                            .source("tandfonline.com")
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
