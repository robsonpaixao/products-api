package com.studies.products_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveData(String key, Object value) {
        redisTemplate.opsForValue().set(key, value, 5, TimeUnit.MINUTES);
    }

    public Object getData(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
