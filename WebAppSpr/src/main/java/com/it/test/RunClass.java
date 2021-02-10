package com.it.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunClass {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        TestClass test = context.getBean("testClass",TestClass.class);
        System.out.printf("t:"+test.getName());
        context.close();
    }
}
