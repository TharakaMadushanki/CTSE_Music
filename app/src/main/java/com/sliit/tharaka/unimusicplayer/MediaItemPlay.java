package com.sliit.tharaka.unimusicplayer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;
import com.sliit.tharaka.unimusicplayer.services.MediaPlayerService;

public class MediaItemPlay extends AppCompatActivity {

    private final static String TAG = "Media Item Lifecycle Watch";
    private MusicHandler song = new MusicHandler();
    private View view;
    private View controllers;
    ViewHolder viewHolder= new ViewHolder();
    private MediaPlayer mediaplayer;
    private MediaPlayerService mediaPlayerService;
    private Boolean isSongSet = false;
    private Boolean isPause = false;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_item_play);
        Log.i(TAG,"Lifecycle Event: onCreate Command");

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.controllers);
        linearLayout.setVisibility(View.VISIBLE);

        song.setSong(getIntent().getIntExtra("SongID", 0));
        song.setSingerName(getIntent().getStringExtra("ArtistName"));
        song.setName(getIntent().getStringExtra("SongName"));

        viewHolder.songName = (TextView) findViewById(R.id.song_title);
        viewHolder.artistName = (TextView) findViewById(R.id.artist_name);
        viewHolder.skipPrev = (ImageView) findViewById(R.id.prev);
        viewHolder.playPause = (ImageView) findViewById(R.id.play_pause);
        viewHolder.skipNext = (ImageView) findViewById(R.id.next);
        viewHolder.textStart = (TextView) findViewById(R.id.startText);
        viewHolder.textEnd = (TextView) findViewById(R.id.endText);
        viewHolder.seekBar = (SeekBar) findViewById(R.id.seekBar1);
        //controllers = findViewById(R.id.controllers);

        viewHolder.songName.setText(song.getName());
        viewHolder.artistName.setText(song.getSingerName());

        viewHolder.playPause.setImageResource(R.drawable.uamp_ic_pause_white_48dp);
        viewHolder.skipPrev.setImageResource(R.drawable.ic_skip_previous_white_48dp);
        viewHolder.skipNext.setImageResource(R.drawable.ic_skip_next_white_48dp);

        mediaPlayerService = new MediaPlayerService();
        mediaPlayerService.CreatePlayer(this, song);
        mediaplayer = mediaplayer.create(this, song.getSong());

        if(mediaplayer.isPlaying()){
            viewHolder.playPause.setImageResource(R.drawable.uamp_ic_pause_white_48dp);
        } else {
            viewHolder.playPause.setImageResource(R.drawable.uamp_ic_play_arrow_white_48dp);
        }

        viewHolder.playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSongSet){
                    if(!isPause) {
                        mediaPlayerService.play();
                        viewHolder.playPause.setImageResource(R.drawable.uamp_ic_pause_white_48dp);
                        isSongSet = true;
                    }
                } else {
                    if(isPause) {
                        viewHolder.playPause.setImageResource(R.drawable.uamp_ic_pause_white_48dp);
                        mediaPlayerService.play();
                        isPause = false;
                    } else {
                        mediaPlayerService.pause();
                        viewHolder.playPause.setImageResource(R.drawable.uamp_ic_play_arrow_white_48dp);
                        isPause = true;
                    }
                }
            }
        });
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Lifecycle Event: onStart Command");
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Lifecycle Event: onResume Command");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayerService.destory();
    }

    private class ViewHolder {
        ImageView skipPrev;
        ImageView skipNext;
        ImageView playPause;
        TextView songName;
        TextView artistName;
        TextView textStart;
        TextView textEnd;
        SeekBar seekBar;
    }

}
