package com.discussion.community.redis;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RedisDemoTest {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public RedisDemo redisDemo;

    @BeforeEach
    public void init() {
        redisDemo = new RedisDemo(redisTemplate);
    }

    @Test
    public void getUser() {
        redisDemo.getUser();
    }

    @Test
    void getAge() {
        String age = redisDemo.getAge("user01", "age");
        assertEquals(age, "5");
    }

    @RepeatedTest(5)
    public void test3() {
        System.out.println("repeated");

    }
}