package com.xh.demo.redisdemo.service.impl;

import com.xh.demo.redisdemo.service.CacheTestService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Xiong Hao
 */
@Service
public class CacheTestServiceImpl implements CacheTestService {
    @Override
    @Cacheable(cacheNames = "sysNameCache", key = "#name")
    public String getName(String name) {
        return String.valueOf(System.currentTimeMillis());
    }

    @Override
    @Cacheable(cacheNames = "sysNameCache", key = "#name")
    public void updateName(String name) {

    }
}