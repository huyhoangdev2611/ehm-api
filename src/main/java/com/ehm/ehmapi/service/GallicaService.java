package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.gallica.GallicaSearchResult;
import com.ehm.ehmapi.model.gallica.Record;
import com.ehm.ehmapi.model.result.Publication;
import com.ehm.ehmapi.model.result.SearchResult;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class GallicaService {

    public SearchResult getGallicaResults(String placeName, int start, int count) {
        try {
            String url = UriComponentsBuilder.fromUriString("https://gallica.bnf.fr/SRU")
                    .queryParam("operation", "searchRetrieve")
                    .queryParam("version", "1.2")
                    .queryParam("query", "dc.title all \"" + placeName + "\"")
                    .queryParam("startRecord", start)
                    .queryParam("maximumRecords", count)
                    .build().toString();

            HttpEntity<?> entity = new HttpEntity<>(null);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<GallicaSearchResult> response = restTemplate.exchange(url, HttpMethod.GET, entity, GallicaSearchResult.class);

            GallicaSearchResult gallicaResult = response.getBody();
            if (gallicaResult != null) {
                List<Record> records = gallicaResult.getRecords();
                int total = gallicaResult.getNumberOfRecords();
                List<Publication> apiResults = new ArrayList<>();

                for (Record record : records) {
                    String source = record.getRecordData().getDc().getSource();
                    String title = record.getRecordData().getDc().getTitle();
                    List<String> creators = record.getRecordData().getDc().getCreator();
                    String date = record.getRecordData().getDc().getDate();

                    String link = record.getExtraRecordData().getLink();
                    String thumbnail = record.getExtraRecordData().getThumbnail();

                    String formattedTitle = title + " (" + date + ")";
                    Publication publication = Publication.builder()
                            .title(formattedTitle)
                            .author(String.valueOf(creators))
                            .desc(source)
                            .url(link)
                            .img(thumbnail)
                            .source("Gallica BNF")
                            .sourceImg("gallica.png")
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
        }catch (Exception e){
            return SearchResult.builder()
                    .items(new ArrayList<>())
                    .total(0)
                    .more(false)
                    .build();
        }

    }
}
