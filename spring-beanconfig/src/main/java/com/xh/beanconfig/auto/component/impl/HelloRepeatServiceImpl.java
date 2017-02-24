package com.xh.beanconfig.auto.component.impl;

import com.xh.beanconfig.auto.component.HelloSerice;
import org.springframework.stereotype.Service;

/**
 * @author Xiong Hao
 */
@Service
public class HelloRepeatServiceImpl implements HelloSerice {

    @Override
    public void testRun() {
        System.out.println("run.....");
    }
}
