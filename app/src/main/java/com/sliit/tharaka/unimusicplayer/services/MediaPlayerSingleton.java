package com.sliit.tharaka.unimusicplayer.services;

import android.content.Context;
import android.media.MediaPlayer;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;

/**
 * Created by Naditha Harshana on 4/9/2018.
 */

public class MediaPlayerSingleton {
    private static final MediaPlayer mediaplayer = new MediaPlayer();

    public static MediaPlayer GetMediaPlayer(MusicHandler song, Context context) {
        mediaplayer.create(context,song.getSong());
        return mediaplayer;
    }


}
