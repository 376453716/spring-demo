package com.xh.beanconfig.manul;

import com.xh.beanconfig.manul.component.HelloDao;
import com.xh.beanconfig.manul.component.HelloSerice;
import com.xh.beanconfig.manul.component.impl.HelloRepeatServiceImpl;
import com.xh.beanconfig.manul.component.impl.HelloServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * spring 手动装配
 *
 * @author Xiong Hao
 */
@Configuration
public class FirstJavaConfiguration {

    @Bean
    public HelloSerice helloSerice() {
        return new HelloServiceImpl();
    }

    @Bean
    public HelloDao helloDao() {
        HelloDao dao = new HelloDao();
        dao.setMessage("dao...");
        return dao;
    }

    @Bean(name = "helloSerice2")
    public HelloSerice helloRepeatService() {
        return new HelloRepeatServiceImpl(helloDao());
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FirstJavaConfiguration.class);
        HelloSerice helloSerice = context.getBean("helloSerice", HelloSerice.class);
        helloSerice.testRun();
        HelloSerice helloSerice2 = context.getBean("helloSerice2", HelloSerice.class);
        helloSerice2.testRun();
    }

}
