package com.ehm.ehmapi.config;

import com.ehm.ehmapi.model.result.SearchResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, SearchResult> searchResultRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, SearchResult> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}

