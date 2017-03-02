package com.xh.demo.redisdemo.dao.impl;

import com.xh.demo.redisdemo.dao.GenericRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Arrays;

/**
 * @author Xiong Hao
 */
public class RedisDaoImpl implements GenericRedisDao {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void del(String... keys) {
        redisTemplate.delete(Arrays.asList(keys));
    }

    private ValueOperations<String, String> getValueOperations() {
        return redisTemplate.opsForValue();
    }

    @Override
    public void set(String key, String value) {
        getValueOperations().set(key, value);
    }

    @Override
    public void set(String key, String value, long liveTime) {

    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public boolean exists(String key) {
        return false;
    }
}
