package com.sliit.tharaka.unimusicplayer.services;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sliit.tharaka.unimusicplayer.R;
import com.sliit.tharaka.unimusicplayer.model.MusicHandler;

import java.util.ArrayList;

/**
 * Created by ASUS on 3/31/2018.
 */

public class MusicAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<MusicHandler> arrayList;
    private android.media.MediaPlayer mediaplayer;
    private boolean flag = true;
    private boolean isPaused = false;
    private int nowPlaying = -1;
    private boolean isPosChanged = false;

    public MusicAdapter(Context context, int layout, ArrayList<MusicHandler> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView txtName, txtSinger;
        ImageView imageViewPlay, imageViewStop;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder viewholder;
        if (convertView == null) {
            viewholder = new ViewHolder();
            LayoutInflater layoutinflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutinflater.inflate(layout, null);
            viewholder.txtName = (TextView) convertView.findViewById(R.id.song_title);
            viewholder.txtSinger = (TextView) convertView.findViewById(R.id.artist_name);
            viewholder.imageViewPlay = (ImageView) convertView.findViewById(R.id.play_eq);
            //viewholder.imageViewStop = (ImageView) convertView.findViewById(R.id.imageViewStop);

            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }

        final MusicHandler music = arrayList.get(position);

        viewholder.txtName.setText(music.getName());
        viewholder.txtSinger.setText(music.getSinger());

        // play music
        viewholder.imageViewPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("from On click", "flag : " + flag + " isPuased : " + isPaused + " isPositionChanged : " + isPosChanged + " position : " + position + " nowPlaying : " + nowPlaying);
                playBackControll(position, viewholder, music);
            }
        }) ;
        return convertView;
    }

    public void playBackControll(int position, ViewHolder viewholder, MusicHandler music) {
        if(position == nowPlaying) {
            isPosChanged = false;
        } else {
            isPosChanged = true;
        }

        if (!isPosChanged) {
            if (isPaused) {
                mediaplayer.start();
                isPaused = false;
                viewholder.imageViewPlay.setImageResource(R.drawable.ic_pause_white_24dp);
            } else {
                mediaplayer.pause();
                isPaused = true;
                viewholder.imageViewPlay.setImageResource(R.drawable.ic_play_arrow_black_36dp);
            }
        } else {
            if(flag) {
                mediaplayer = android.media.MediaPlayer.create(context, music.getSong());
                mediaplayer.start();
                viewholder.imageViewPlay.setImageResource(R.drawable.ic_pause_white_24dp);
                flag = false;
                nowPlaying = position;
            } else {
                viewholder.imageViewPlay.setImageResource(R.drawable.ic_play_arrow_black_36dp);
                if(mediaplayer.isPlaying()){
                    mediaplayer.stop();
                }
                mediaplayer = null;
                mediaplayer = android.media.MediaPlayer.create(context, music.getSong());
                mediaplayer.start();
                viewholder.imageViewPlay.setImageResource(R.drawable.ic_pause_white_24dp);
                flag = false;
                nowPlaying = position;
            }
        }
    }
}
