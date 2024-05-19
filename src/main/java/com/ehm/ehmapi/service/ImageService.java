package com.ehm.ehmapi.service;

import com.ehm.ehmapi.model.result.SearchResult;
import com.ehm.ehmapi.repository.SearchResultRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ImageService {
    @Autowired
    private BingImageService bingImageService;

    @Autowired
    private SearchResultRepository imageSearchResultRepository;

    public SearchResult getImages(String keyword, Integer page, Integer size) {
        int start = size * (page - 1) + 1;
        String redisKey = "images:" + keyword;
        SearchResult cachedResult = imageSearchResultRepository.findById(redisKey);
        if (page == 1 && cachedResult != null) {
            return cachedResult;
        } else {
            List<CompletableFuture<SearchResult>> futures = List.of(
                    CompletableFuture.supplyAsync(() -> bingImageService.getBingImageResults(keyword, start, size))
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

            SearchResult response = SearchResult.builder()
                    .items(items)
                    .more(more)
                    .total(total)
                    .build();

            if (page == 1) {
                imageSearchResultRepository.save(redisKey, response, Duration.ofDays(30));
            }

            return response;
        }
    }
}
