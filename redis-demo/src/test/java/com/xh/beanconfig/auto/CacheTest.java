package com.xh.beanconfig.auto;

import com.xh.demo.redisdemo.RedisConfig;
import com.xh.demo.redisdemo.service.CacheTestService;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Xiong Hao
 */
@RunWith(SpringJUnit4ClassRunnerLog4j.class)
@ContextConfiguration(classes = RedisConfig.class)
public class CacheTest {
    /*static {
        PropertyConfigurator.configure("log4j.properties");
    }*/

    @Autowired
    private CacheTestService cacheTestService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test() throws InterruptedException {
        String name = "xiongh";

        System.out.println(cacheTestService.getName(name));

        Cache cache = cacheManager.getCache("sysNameCache");
        System.out.println("cacheName===>" + cache.getName());
//        System.out.println("cache===>" + cache.get(name).get());

        System.out.println("休眠2秒");
        Thread.sleep(2000);

        System.out.println(cacheTestService.getName(name));

        System.out.println("休眠2秒");
        Thread.sleep(2000);

        System.out.println(cacheTestService.getName(name));

        System.out.println("休眠10秒");
        Thread.sleep(10000);

        System.out.println(cacheTestService.getName(name));
    }
}
