package com.it.annatationonly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private int volume;

    private Music music;
    @Autowired
    public MusicPlayer(Music m){
        this.music=m;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}


