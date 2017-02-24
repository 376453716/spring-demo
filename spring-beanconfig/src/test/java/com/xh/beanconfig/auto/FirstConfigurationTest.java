package com.xh.beanconfig.auto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import com.xh.beanconfig.auto.component.HelloSerice;

/**
 * spring 自动装配
 *
 * @author Xiong Hao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FirstConfiguration.class)
public class FirstConfigurationTest {

    @Resource(name = "helloServiceImpl")
    private HelloSerice helloServiceImpl;

    @Resource(name = "helloRepeatServiceImpl")
    private HelloSerice helloMoreServiceImpl;

    @Test
    public void testRun() {
        helloServiceImpl.testRun();
        helloMoreServiceImpl.testRun();
    }
}
