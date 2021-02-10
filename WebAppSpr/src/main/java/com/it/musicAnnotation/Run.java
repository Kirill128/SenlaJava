package com.it.musicAnnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
       // Music music= context.getBean("music",Music.class);
       // MusicPlayer plyer=new MusicPlayer(music);
       // plyer.play();
        Music music=context.getBean("rockMusicBean",Music.class);
        System.out.printf(music.getMusic());
        context.close();
    }
}
