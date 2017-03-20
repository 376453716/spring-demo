package com.xh.beanconfig.manul.component.impl;

import com.xh.beanconfig.manul.component.HelloSerice;
import org.springframework.stereotype.Service;

/**
 * @author Xiong Hao
 */
public class HelloRepeatServiceImpl implements HelloSerice {

    @Override
    public void testRun() {
        System.out.println("run2.....");
    }
}
