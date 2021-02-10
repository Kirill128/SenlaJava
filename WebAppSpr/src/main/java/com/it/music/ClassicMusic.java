package com.it.music;

import org.springframework.stereotype.Component;
import sun.reflect.generics.tree.ClassSignature;
@Component
public class ClassicMusic implements Music{
    private ClassicMusic(){}

    public static ClassicMusic getClassicMusic(){
        return new ClassicMusic();
    }

    @Override
    public String getMusic() {
        return "Classics";
    }
}
