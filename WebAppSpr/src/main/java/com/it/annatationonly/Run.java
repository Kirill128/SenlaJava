package com.it.annatationonly;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Run {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigurationClass.class);
        MusicPlayer player=context.getBean(MusicPlayer.class);
    }
}
