package com.sliit.tharaka.unimusicplayer.services;

import android.media.MediaPlayer;
import android.content.Context;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;

public class MediaPlayerService {

    private MediaPlayer mediaplayer;

    public MediaPlayerService() {
    }

    public void CreatePlayer(Context context, MusicHandler musicHandler) {
        mediaplayer = mediaplayer.create(context, musicHandler.getSong());
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

    public void destory(){
        if(mediaplayer != null) {
            if (mediaplayer.isPlaying()) {
                mediaplayer.stop();
                mediaplayer.release();
            }
        }
    }

    public void release() {
        mediaplayer.release();
    }
}
