package com.discussion.community.redis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author jie
 */
@Component
public class RedisDemo {

    final RedisTemplate<String, String> redisTemplate;

    public RedisDemo(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void getUser() {
        HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
        Map<Object, Object> user01 = opsForHash.entries("user01");
        System.out.println("user01: " + user01);
    }

    public String getAge(String key, String field) {
        HashOperations<String, Object, Object> operations = redisTemplate.opsForHash();
        return (String) operations.get(key, field);
    }
}
