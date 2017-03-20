package com.xh.beanconfig.auto;

import com.xh.beanconfig.auto.component.HelloSerice;
import com.xh.beanconfig.manul.FirstJavaConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * spring 自动装配
 *
 * @author Xiong Hao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FirstJavaConfiguration.class)
public class FirstJavaConfigurationTest {

    private HelloSerice helloServiceImpl;

    private HelloSerice helloMoreServiceImpl;

    @Test
    public void testRun() {
        helloServiceImpl.testRun();
        helloMoreServiceImpl.testRun();
    }
}
