package com.sliit.tharaka.unimusicplayer;

import android.app.Application;
import android.media.MediaPlayer;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;

public class MusicApplication extends Application {

    static MediaPlayer mediaPlayer;

    public static void setMediaPlayerObject(MediaPlayer mediaPlayer){
        MusicApplication.mediaPlayer = mediaPlayer;
    }

    public static MediaPlayer getMediaPlayerObject(){
        return mediaPlayer;
    }
}
