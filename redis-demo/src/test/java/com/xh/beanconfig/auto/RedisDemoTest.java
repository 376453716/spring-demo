package com.xh.beanconfig.auto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xiong Hao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class RedisDemoTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> setOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, String> hashOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, String> zSetOperations;

    @Test
    public void testValue() {
        for (int i = 0; i < 10; i++) {
            valueOperations.set("a" + i, "value" + i);
        }
        List<String> valList = valueOperations.multiGet(Arrays.asList("a1", "a3", "a5", "a9"));
        System.out.println(valList);
        valueOperations.set("bit", "00000000");
        valueOperations.setBit("bit", 0, true);
        Assert.assertTrue(valueOperations.getBit("bit", 0));
    }

    @Test
    public void testUpdateToken() {
        long timeStamp = System.currentTimeMillis();
    }

}
