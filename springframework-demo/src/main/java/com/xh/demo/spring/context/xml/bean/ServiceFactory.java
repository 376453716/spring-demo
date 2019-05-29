package com.xh.demo.spring.context.xml.bean;

/**
 * @author Xiong Hao
 * @date 2019-05-29
 */
public class ServiceFactory {

    private static final XmlService xmlService = new XmlService();

    static {
        xmlService.setMethod("method5");
        xmlService.setName("xmlService5");
    }

    public static XmlService getInstants() {
        return xmlService;
    }
}
