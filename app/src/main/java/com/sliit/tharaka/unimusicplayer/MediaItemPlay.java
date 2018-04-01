package com.sliit.tharaka.unimusicplayer;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;
import com.sliit.tharaka.unimusicplayer.services.MediaPlayerService;


public class MediaItemPlay extends AppCompatActivity {

    private MusicHandler song = new MusicHandler();
    private View view;
    private View controllers;
    ViewHolder viewHolder= new ViewHolder();
    private MediaPlayer mediaplayer;
    private MediaPlayerService mediaPlayerService;
    private Boolean isSongSet = false;
    private Boolean isPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_item_play);

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
        controllers = findViewById(R.id.controllers);

    }

    @Override
    protected void onStart() {
        super.onStart();

        viewHolder.songName.setText(song.getName());
        viewHolder.artistName.setText(song.getSingerName());

        viewHolder.playPause.setImageResource(R.drawable.uamp_ic_pause_white_48dp);
        viewHolder.skipPrev.setImageResource(R.drawable.ic_skip_previous_white_48dp);
        viewHolder.skipNext.setImageResource(R.drawable.ic_skip_next_white_48dp);

        mediaPlayerService = new MediaPlayerService(mediaplayer, song);
        mediaPlayerService.CreatePlayer(this, song);
        mediaplayer = mediaplayer.create(this, song.getSong());

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mediaplayer.isPlaying()){
            viewHolder.playPause.setImageResource(R.drawable.uamp_ic_pause_white_48dp);
        } else {
            viewHolder.playPause.setImageResource(R.drawable.ic_play_arrow_black_36dp);
        }

        viewHolder.playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSongSet){
                    if(!isPause) {
                        mediaPlayerService.play();
                        viewHolder.playPause.setImageResource(R.drawable.uamp_ic_pause_white_48dp);
                        isSongSet = true;
                    } else {
                        viewHolder.playPause.setImageResource(R.drawable.uamp_ic_pause_white_48dp);
                        mediaPlayerService.play();
                    }
                } else {
                    if(isPause) {
                        viewHolder.playPause.setImageResource(R.drawable.uamp_ic_pause_white_48dp);
                        mediaPlayerService.play();
                        isPause = false;
                    } else {
                        mediaPlayerService.pause();
                        viewHolder.playPause.setImageResource(R.drawable.ic_play_arrow_black_36dp);
                        isPause = true;
                    }
                }

            }
        });
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

    public MediaItemPlay() {

    }

    public MediaItemPlay(MediaPlayer mediaPlayer, MusicHandler song) {
        this.mediaplayer = mediaPlayer;
        this.song = song;
    }
}
