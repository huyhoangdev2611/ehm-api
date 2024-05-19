package com.ehm.ehmapi.repository;

import com.ehm.ehmapi.model.result.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@org.springframework.stereotype.Repository
public class SearchResultRepository {
    @Autowired
    private RedisTemplate<String, SearchResult> redisTemplate;

    public SearchResult findById(String rediskey) {
        try {
            return redisTemplate.opsForValue().get(rediskey);
        } catch (Exception e) {
            return null;
        }
    }

    public void save(String rediskey, SearchResult result, Duration duration) {
        try {
            redisTemplate.opsForValue().set(rediskey, result, duration);
        } catch (Exception e) {
        }
    }

    public void expire(String rediskey, Duration duration) {
        redisTemplate.expire(rediskey, duration);
    }
}
