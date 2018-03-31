package com.sliit.tharaka.unimusicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.media.MediaPlayer;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;

/**
 * Created by ASUS on 3/31/2018.
 */

public class MediaItemPlay extends Activity {

    private MediaPlayer mediaplayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_item_list);

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
