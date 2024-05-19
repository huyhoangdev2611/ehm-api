package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.result.SearchResult;
import com.ehm.ehmapi.model.result.Video;
import com.ehm.ehmapi.model.videos.imc.ImcData;
import com.ehm.ehmapi.model.videos.imc.ImcResults;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class IMCService {

    public SearchResult getIMCVideoResults(String placeName, int start, int count) {
        try {
            int page = (start / count) + 1;
            String endpoint = "https://imediacities.hpc.cineca.it/api/search";
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            String body = "{" +
                    "\"match\": {" +
                    "\"term\": \"" + placeName + "\"," +
                    "\"fields\": [\"title\", \"keyword\", \"description\"]" +
                    "}," +
                    "\"filter\": {" +
                    "\"type\": \"all\"," +
                    "\"provider\": null," +
                    "\"city\": null," +
                    "\"iprstatus\": null," +
                    "\"yearfrom\": 1890," +
                    "\"yearto\": 1999," +
                    "\"terms\": []," +
                    "\"missingDate\": true" +
                    "}" +
                    "}";

            HttpEntity<String> entity = new HttpEntity<>(body, headers);

            String link = UriComponentsBuilder.fromUriString(endpoint)
                    .queryParam("currentpage", page)
                    .queryParam("perpage", count)
                    .build()
                    .toString();

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<ImcResults> response = restTemplate.exchange(link, HttpMethod.POST, entity, ImcResults.class);

            ImcResults imcResponse = response.getBody();
            if (imcResponse != null) {
                List<Video> videos = new ArrayList<>();
                int total = imcResponse.getMeta().getTotalItems();
                List<ImcData> imcDataList = imcResponse.getData();
                for (ImcData imcData : imcDataList) {
                    String title = "";
                    if (imcData.getTitles() != null && !imcData.getTitles().isEmpty()) {
                        title = imcData.getTitles().get(0).getText();
                    }
                    String type = imcData.getType();
                    String id = imcData.getId();
                    String url = "https://imediacities.hpc.cineca.it/app/catalog/" + (type.equals("aventity") ? "videos/" : "images/") + id;
                    String desc = "";
                    if (imcData.getDescriptions() != null && imcData.getDescriptions().size() >= 2) {
                        desc = imcData.getDescriptions().get(1).getText();
                    }
                    String img = "";
                    if (imcData.getLinks() != null) {
                        img = imcData.getLinks().getThumbnail();
                    }
                    videos.add(Video.builder()
                            .title(title)
                            .desc(desc)
                            .url(url)
                            .img(img)
                            .source("imediacities.eu")
                            .build());
                }

                return SearchResult.builder()
                        .items(videos)
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
