package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.result.Publication;
import com.ehm.ehmapi.model.result.SearchResult;
import com.ehm.ehmapi.model.scopus.Entry;
import com.ehm.ehmapi.model.scopus.ScopusResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ScopusService {
    @Value("${application.scopusApiKey}")
    private static String scopusApiKey;
    public SearchResult getScopusResults(String keyword, Integer start, Integer count) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
//        Map<String, ?> requestParams = Map.of(
//                "query", "TITLE-ABS-KEY(" + keyword + ") AND SUBJAREA(ARTS)",
//                "start", start,
//                "count", count,
//                "apiKey", "38da2df0f6eee6827f5cfab0fb2bed9d"
//        );
            String url = UriComponentsBuilder.fromUriString("https://api.elsevier.com/content/search/scopus")
                    .queryParam("query", "TITLE-ABS-KEY(" + keyword + ") AND SUBJAREA(ARTS)")
                    .queryParam("start", start)
                    .queryParam("count", count)
                    .queryParam("apiKey", scopusApiKey)
                    .build().toString();

            ResponseEntity<ScopusResult> response = restTemplate.exchange(url, HttpMethod.GET, entity, ScopusResult.class);
            if (response.getBody() == null) {
                return null;
            }

            List<Publication> apiResults = List.of();
            Integer total = 0;

            if (!response.getBody().getSearchResults().getEntry().isEmpty()) {
                List<Entry> entries = response.getBody().getSearchResults().getEntry();
                apiResults = entries.stream().filter(e -> e.getLink() != null && e.getDcTitle() != null)
                        .map(entry -> {
                            String title = entry.getDcTitle();
                            String postUrl = entry.getLink().get(2).getHref();
                            String publicationName = Optional.ofNullable(entry.getPrismPublicationName()).orElse("");
                            String volume = Optional.ofNullable(entry.getPrismVolume()).orElse("");
                            String coverDate = Optional.ofNullable(entry.getPrismCoverDate()).orElse("");
                            String prism = String.format("%s, Volume %s, %s", publicationName, volume, coverDate);
                            String creator = Optional.ofNullable(entry.getDcCreator()).orElse("");
                            return Publication.builder()
                                    .title(title)
                                    .url(postUrl)
                                    .desc(prism)
                                    .author(creator)
                                    .source("Scopus Elsevier")
                                    .sourceImg("scopus.svg")
                                    .build();

                        }).collect(Collectors.toList());
                total = response.getBody().getSearchResults().getOpensearchTotalResults();
            }
            return SearchResult.builder()
                    .items(apiResults)
                    .total(total)
                    .more(start + count < total)
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