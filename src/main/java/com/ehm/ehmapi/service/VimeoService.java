package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.result.SearchResult;
import com.ehm.ehmapi.model.result.Video;
import com.ehm.ehmapi.model.videos.vimeo.VimeoData;
import com.ehm.ehmapi.model.videos.vimeo.VimeoResults;
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
public class VimeoService {
    @Value("${application.vimeoAccessToken}")
    private String vimeoAccessToken;

    public SearchResult getVimeoVideoResults(String placeName, int page, int count) {
        try {
            String endpoint = "https://api.vimeo.com/videos";

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "bearer " + vimeoAccessToken);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            String link = UriComponentsBuilder.fromUriString(endpoint)
                    .queryParam("query", placeName)
                    .queryParam("page", page)
                    .queryParam("per_page", count)
                    .build()
                    .toString();

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<VimeoResults> response = restTemplate.exchange(link, HttpMethod.GET, entity, VimeoResults.class);

            VimeoResults vimeoResponse = response.getBody();
            if (vimeoResponse != null) {
                List<Video> videos = new ArrayList<>();
                int total = vimeoResponse.getTotal();
                List<VimeoData> vimeoDataList = vimeoResponse.getData();
                for (VimeoData vimeoData : vimeoDataList) {
                    String title = vimeoData.getName();
                    String url = String.valueOf(vimeoData.getLink());
                    String creator = vimeoData.getUser().getName();
                    String desc = vimeoData.getDescription();
                    String img = vimeoData.getPictures().getSizes().get(vimeoData.getPictures().getSizes().size() - 1).getLink();
                    videos.add(Video.builder()
                            .title(title)
                            .desc(desc)
                            .url(url)
                            .author(creator)
                            .img(img)
                            .source("vimeo.com")
                            .build());
                }

                return SearchResult.builder()
                        .items(videos)
                        .total(total)
                        .more(page * count < total)
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
