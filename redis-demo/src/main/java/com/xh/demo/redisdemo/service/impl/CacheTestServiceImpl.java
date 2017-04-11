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
    @Cacheable(cacheNames = "sysNameCache", key = "#name",cacheManager="cacheManager")
    public String getName(String name) {
        System.out.println("invoke...getName");
        System.out.println(this.getClass());
        return String.valueOf(System.currentTimeMillis());
    }

    @Override
    @CacheEvict(cacheNames = "sysNameCache", key = "#name")
    public void updateName(String name) {

    }
}