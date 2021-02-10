package com.it.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    @Autowired
    public MusicPlayer(Music music)
    {
        this.music=music;
        System.out.println("MusicPlayer constructor");
    }
    public void play(){
        System.out.printf(music.getMusic());
    }
    public void initMusicPl(){
        System.out.println("Init Music Player");
    }
    public void destroyMusicPl(){
        System.out.println("Destroy Music Player");
    }
}
