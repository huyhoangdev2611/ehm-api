package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.result.SearchResult;
import com.ehm.ehmapi.model.result.Video;
import com.ehm.ehmapi.model.videos.youtube.Item;
import com.ehm.ehmapi.model.videos.youtube.YoutubeResults;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeService {
    @Value("${application.youtubeApiKey}")
    private String youtubeApiKey;

    public SearchResult getYoutubeResults(String placeName, String pageToken, int count) {
        try {
            String encodedPlaceName = UriComponentsBuilder.fromUriString(placeName).build().encode().toUriString();
            String endpoint = "https://www.googleapis.com/youtube/v3/search";

            String link = UriComponentsBuilder.fromUriString(endpoint)
                    .queryParam("part", "snippet")
                    .queryParam("q", encodedPlaceName)
                    .queryParam("maxResults", count)
                    .queryParam("key", youtubeApiKey)
                    .queryParam("pageToken", pageToken)
                    .build()
                    .toString();

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<YoutubeResults> response = restTemplate.exchange(link, HttpMethod.GET, null, YoutubeResults.class);

            YoutubeResults youtubeResponse = response.getBody();
            if (youtubeResponse != null) {
                List<Video> videos = new ArrayList<>();
                int total = youtubeResponse.getPageInfo().getTotalResults();
                String nextPageToken = youtubeResponse.getNextPageToken();
                List<Item> items = youtubeResponse.getItems();
                for (Item item : items) {
                    if (!item.getId().getKind().equals("youtube#video")) continue;
                    String videoId = item.getId().getVideoId();
                    String title = item.getSnippet().getTitle();
                    String description = item.getSnippet().getDescription();
                    String thumbnail = item.getSnippet().getThumbnails().getMedium().getUrl();
                    String channelId = item.getSnippet().getChannelId();
                    String channelTitle = item.getSnippet().getChannelTitle();
                    videos.add(Video.builder()
                            .title(title)
                            .author(channelTitle)
                            .desc(description)
                            .url("https://www.youtube.com/watch?v=" + videoId)
                            .img(thumbnail)
                            .source("youtube.com")
                            .build());
                }

                return SearchResult.builder()
                        .items(videos)
                        .total(total)
                        .more(nextPageToken != null)
                        .nextPageToken(nextPageToken)
                        .build();
            }

            return SearchResult.builder()
                    .items(new ArrayList<>())
                    .total(0)
                    .more(false)
                    .nextPageToken("")
                    .build();
        } catch (Exception e) {
            return SearchResult.builder()
                    .items(new ArrayList<>())
                    .total(0)
                    .more(false)
                    .nextPageToken("")
                    .build();
        }

    }
}
