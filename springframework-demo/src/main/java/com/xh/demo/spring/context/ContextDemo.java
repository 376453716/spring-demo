package com.xh.demo.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Xiong Hao
 * @date 2019-05-29
 */
public class ContextDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextDemo.class);

    }
}
