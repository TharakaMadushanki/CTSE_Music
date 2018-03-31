package com.sliit.tharaka.unimusicplayer.services;

import android.content.Context;
import android.media.MediaPlayer;
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
    private MediaPlayer mediaplayer;
    private boolean flag = true;
    private boolean isPaused = false;

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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
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

                Log.i("from On click", "flag : " + flag + " isPuased : " + isPaused);
                if (flag && !isPaused) {
                    mediaplayer = MediaPlayer.create(context, music.getSong());
                    flag = false;
                    mediaplayer.setVolume(50, 50);
                    mediaplayer.start();
                    viewholder.imageViewPlay.setImageResource(R.drawable.ic_pause_white_24dp);
                } else {
                    if (isPaused) {
                        mediaplayer.start();
                        viewholder.imageViewPlay.setImageResource(R.drawable.ic_pause_white_24dp);
                        isPaused = false;
                    } else {
                        mediaplayer.pause();
                        viewholder.imageViewPlay.setImageResource(R.drawable.ic_play_arrow_black_36dp);
                        isPaused = true;
                    }
                }

            }
        }) ;

        return convertView;
    }

}
