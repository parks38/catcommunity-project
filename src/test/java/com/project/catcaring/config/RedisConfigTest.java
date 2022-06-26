package com.project.catcaring.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisConfigTest {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    void redisConnectionTest() {
        String key = "USER_ID";
        String value = "userSessionTest";

        /**
         *  RedisTemplate 제 자료 타입
         *  ValueOperations, ListOperations, SetOperations,
         *  HashOperations, StreamOperations
         */
        ValueOperations<String, String> userSession = redisTemplate.opsForValue();
        userSession.set(key, value);

        String resultData = userSession.get(key);
        Assertions.assertThat(resultData).isEqualTo(value);
    }
}
