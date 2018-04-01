package com.sliit.tharaka.unimusicplayer.model;

/**
 * Created by ASUS on 3/31/2018.
 */

public class MusicHandler {

    private String songName;
    private String singerName;
    private int song;

    public MusicHandler () {

    }
    public MusicHandler(String name, String singer, int song) {
        this.songName = name;
        this.singerName = singer;
        this.song = song;
    }

    public String getName() {
        return songName;
    }

    public void setName(String name) {
        this.songName = name;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}

