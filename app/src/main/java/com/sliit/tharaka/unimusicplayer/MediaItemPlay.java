package com.sliit.tharaka.unimusicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;

/**
 * Created by ASUS on 3/31/2018.
 */

public class MediaItemPlay extends AppCompatActivity {

    private MediaPlayer mediaplayer;
    private MusicHandler song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_item_list);

    }

    public  MediaItemPlay(){

    }
    public MediaItemPlay(MediaPlayer mediaPlayer, MusicHandler song) {
        this.mediaplayer = mediaPlayer;
        this.song = song;
    }
    public void CreatePlayer(Context context, MusicHandler song) {

        mediaplayer = mediaplayer.create(context, song.getSong());
    }

    public void play() {
        mediaplayer.start();
    }

    public void pause() {
        mediaplayer.pause();
    }

    public void stop() {
        mediaplayer.stop();
    }

    public void release() {
        mediaplayer.release();
    }
}
