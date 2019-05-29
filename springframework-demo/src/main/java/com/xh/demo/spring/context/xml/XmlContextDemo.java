package com.xh.demo.spring.context.xml;

import com.xh.demo.spring.context.xml.bean.XmlService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author Xiong Hao
 * @date 2019-05-29
 */
public class XmlContextDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:xml/context.xml");
        XmlService service1 = context.getBean("xmlService1", XmlService.class);
        XmlService service2 = context.getBean("xmlService2", XmlService.class);
        XmlService service3 = context.getBean("xmlService3", XmlService.class);
        XmlService service4 = context.getBean("xmlService4", XmlService.class);
        XmlService service5 = context.getBean("xmlService5", XmlService.class);
        System.out.println(service1.getUserService());
        System.out.println(service2.getName());
        System.out.println(service3.getName());
        System.out.println(service4.getName());
        System.out.println(service5.getName());
        context.refresh();
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    }
}
