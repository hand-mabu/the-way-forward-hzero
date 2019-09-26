package com.hand.infra.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    private int timeout;

    private String password;

    @Value("${spring.redis.jedis.pool.max-active}")
    private int poolMaxTotal;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int poolMaxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private int poolMaxWait;
}
