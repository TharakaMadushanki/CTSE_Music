package com.sliit.tharaka.unimusicplayer;

import android.app.Service;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyBackgroundService extends Service {

    MediaPlayer mediaPlayer;
    private final static String TAG = "Service Lifecycle watch";

    public MyBackgroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.i(TAG,"Lifecycle Event: onCreate Command");
        mediaPlayer = new MediaPlayer();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"Lifecycle Event: onStart Command");
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"Lifecycle Event: onDestroy Command");
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }

}
