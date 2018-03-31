package com.sliit.tharaka.unimusicplayer.services;

import android.media.MediaPlayer;
import android.content.Context;
import com.sliit.tharaka.unimusicplayer.model.MusicHandler;

/**
 * Created by ASUS on 3/31/2018.
 */

public class MediaPlayerService {

    private MediaPlayer mediaplayer;
    private MusicHandler song;

    public MediaPlayerService(MediaPlayer mediaplayer, MusicHandler song) {
        this.mediaplayer = mediaplayer;
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
