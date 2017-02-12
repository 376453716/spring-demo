package com.xh.application;

import com.xh.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xiong Hao
 */
@Configuration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.xh");
        /*MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
        messagePrinter.printMessage();*/
        MessageService messageService = context.getBean(MessageService.class);
        System.out.println("===>" + messageService.message());
    }
}
