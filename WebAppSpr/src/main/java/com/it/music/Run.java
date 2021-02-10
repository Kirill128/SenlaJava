package com.it.music;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
       // Music music= context.getBean("music",Music.class);
       // MusicPlayer plyer=new MusicPlayer(music);
       // plyer.play();

        MusicPlayer player= context.getBean("musicPlayer",MusicPlayer.class);
        player.play();
        //factory example
        Music music1=context.getBean("classicMusic",Music.class);
        Music music2=context.getBean("classicMusic",Music.class);
        System.out.println("Music1 == Music2 :"+ (music1==music2) );
        context.close();
    }
}
