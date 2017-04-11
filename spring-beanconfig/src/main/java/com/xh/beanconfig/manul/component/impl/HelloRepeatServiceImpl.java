package com.xh.beanconfig.manul.component.impl;

import com.xh.beanconfig.manul.component.HelloDao;
import com.xh.beanconfig.manul.component.HelloSerice;
import org.springframework.stereotype.Service;

/**
 * @author Xiong Hao
 */
public class HelloRepeatServiceImpl implements HelloSerice {

    private HelloDao helloDao;

    public HelloRepeatServiceImpl(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    @Override
    public void testRun() {
        System.out.println("run2....." + helloDao.getMessage());
    }
}
