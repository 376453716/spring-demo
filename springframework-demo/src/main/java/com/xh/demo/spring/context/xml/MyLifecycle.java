package com.xh.demo.spring.context.xml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.Lifecycle;

/**
 * @author Xiong Hao
 * @date 2019-05-29
 */
@Slf4j
public class MyLifecycle implements Lifecycle {

    @Override
    public void start() {
        log.info("life cycle start....");
    }

    @Override
    public void stop() {
        log.info("life cycle stop....");
    }

    @Override
    public boolean isRunning() {
        log.info("life cycle isRunning....");
        return false;
    }

}
