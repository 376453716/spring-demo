package com.xh.demo.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.NumberUtils;

/**
 * @author Xiong Hao
 */
@Configuration
@ComponentScan
//<cache:annotation-driven/>
@EnableCaching
@PropertySource("classpath:redis.properties")
public class RedisConfig {

    @Autowired
    Environment env;

    @Bean
    public CacheManager cacheManager() {
        RedisCacheManager manager = new RedisCacheManager(redisTemplate());
        manager.setDefaultExpiration(10000);
        return manager;
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        /*System.out.println(env.getProperty("spring.redis.host"));*/
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("192.168.1.80");
        factory.setDatabase(1);
        return factory;
    }
}
