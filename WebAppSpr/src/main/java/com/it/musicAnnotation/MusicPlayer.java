package com.it.musicAnnotation;

public class MusicPlayer {
    private Music music;
    private String name;
    private int volume;



    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private int radius;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
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
