package com.xh.beanconfig.auto.component.impl;

import com.xh.beanconfig.auto.component.HelloSerice;
import org.springframework.stereotype.Service;

/**
 * @author Xiong Hao
 */
public class HelloServiceImpl implements HelloSerice {

    @Override
    public void testRun() {
        System.out.println("run.....");
    }
}
