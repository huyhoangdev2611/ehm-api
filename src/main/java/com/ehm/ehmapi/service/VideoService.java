package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.result.SearchResult;
import com.ehm.ehmapi.repository.SearchResultRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.Collection;

@Service
@Slf4j
@AllArgsConstructor
public class VideoService {
    @Autowired
    private VimeoService vimeoService;

    @Autowired
    private IMCService imcService;

    @Autowired
    private YoutubeService youtubeService;

    @Autowired
    private SearchResultRepository videoSearchResultRepository;

    public SearchResult getVideo(String keyword, Integer page, Integer size, String pageToken) {
        int start = size * (page - 1) + 1;
        String redisKey = "videos:" + keyword;
        SearchResult cachedResult = videoSearchResultRepository.findById(redisKey);
        if (page == 1 && cachedResult != null) {
            return cachedResult;
        } else {
            List<CompletableFuture<SearchResult>> futures = List.of(
                    CompletableFuture.supplyAsync(() -> youtubeService.getYoutubeResults(keyword, pageToken, size)),
                    CompletableFuture.supplyAsync(() -> vimeoService.getVimeoVideoResults(keyword, start, size)),
                    CompletableFuture.supplyAsync(() -> imcService.getIMCVideoResults(keyword, start, size))
            );

            List<SearchResult> results = futures.stream()
                    .map(CompletableFuture::join)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            List<?> items = results.stream()
                    .map(SearchResult::getItems)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

            Boolean more = results.stream().anyMatch(SearchResult::getMore);
            Integer total = results.stream().mapToInt(SearchResult::getTotal).sum();
            String nextPageToken = "";
            if (results.get(0).getNextPageToken() != null) {
                nextPageToken = results.get(0).getNextPageToken();
            }

            SearchResult response = SearchResult.builder()
                    .items(items)
                    .more(more)
                    .nextPageToken(nextPageToken)
                    .total(total)
                    .build();

            if (page == 1) {
                videoSearchResultRepository.save(redisKey, response, Duration.ofDays(30));
            }

            return response;
        }
    }

}
