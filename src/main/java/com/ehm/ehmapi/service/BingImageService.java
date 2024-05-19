package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.bingimg.BingImgResults;
import com.ehm.ehmapi.model.bingimg.BingValue;
import com.ehm.ehmapi.model.result.Image;
import com.ehm.ehmapi.model.result.SearchResult;
import org.springframework.beans.factory.annotation.Value;
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
public class BingImageService {
    @Value("${application.bingApiKey}")
    private String apiKey;
    @Value("${application.bingEndpoint}")
    private String endpoint;

    public SearchResult getBingImageResults(String placeName, int start, int count) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Ocp-Apim-Subscription-Key", apiKey);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            String link = UriComponentsBuilder.fromUriString(endpoint)
                    .queryParam("q", placeName)
                    .queryParam("count", count)
                    .queryParam("offset", start - 1)
                    .build()
                    .toString();

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<BingImgResults> response = restTemplate.exchange(link, HttpMethod.GET, entity, BingImgResults.class);

            BingImgResults bingImgResults = response.getBody();
            if (bingImgResults != null) {
                List<Image> images = new ArrayList<>();
                int total = bingImgResults.getTotalEstimatedMatches();
                List<BingValue> bingValues = bingImgResults.getValue();
                for (BingValue bingValue : bingValues) {
                    String title = bingValue.getName();
                    String url = bingValue.getHostPageUrl();
                    String desc = "";
                    String author = "";
                    String img = bingValue.getThumbnailUrl();
                    String source = "";
                    if (bingValue.getHostPageDomainFriendlyName() != null && !bingValue.getHostPageDomainFriendlyName().isEmpty()) {
                        source = bingValue.getHostPageDomainFriendlyName();
                    }
                    Image image = Image.builder()
                            .title(title)
                            .desc(desc)
                            .url(url)
                            .author(author)
                            .img(img)
                            .source(source)
                            .build();

                    images.add(image);
                }

                return SearchResult.builder()
                        .items(images)
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
            e.printStackTrace();
            return SearchResult.builder()
                    .items(new ArrayList<>())
                    .total(0)
                    .more(false)
                    .build();
        }

    }
}
