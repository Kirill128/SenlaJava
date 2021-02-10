package com.it.musicAnnotation;

public class ClassicMusic implements Music {
    private ClassicMusic(){}

    public static ClassicMusic getClassicMusic(){
        return new ClassicMusic();
    }

    @Override
    public String getMusic() {
        return "Classics";
    }
}
