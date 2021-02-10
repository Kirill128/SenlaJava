package com.it.musicAnnotation;

import org.springframework.stereotype.Component;

@Component("rockMusicBean")
public class RockMusic implements Music {
    @Override
    public String getMusic() {
        return "Rock";
    }
}
