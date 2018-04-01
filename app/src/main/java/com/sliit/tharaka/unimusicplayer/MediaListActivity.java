package com.sliit.tharaka.unimusicplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;
import com.sliit.tharaka.unimusicplayer.services.MusicAdapter;

import java.util.ArrayList;

public class MediaListActivity extends AppCompatActivity{

    private final static String TAG = "Media List Lifecycle Watch";
    private ArrayList<MusicHandler> arrayList;
    private ListView songListView;
    private MusicAdapter musicAdapter;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_item_list);
        Log.i(TAG,"Lifecycle Event: onCreate Command");

        songListView = (ListView) findViewById(R.id.song_list);
        arrayList = new ArrayList<>();
        arrayList.add(new MusicHandler("Idoraye Nagara Kone", "Amal Perera", R.raw.idorayenagarakone));
        arrayList.add(new MusicHandler("Mal Pita Mal", "Amal Perera Cover", R.raw.malpitamal));
        arrayList.add(new MusicHandler("Ran Meevitha", "Amal Perera", R.raw.ranmeevitha));
        arrayList.add(new MusicHandler("Sanda Midulata Enawa", "Amal Perera Cover", R.raw.sandamidulataenawa));
        arrayList.add(new MusicHandler("Kalpana Lowa Mal","Api Machan Cover", R.raw.kalpanalowa));
        arrayList.add(new MusicHandler("Pana Mada Kadithi","Sunil Edirisinghe", R.raw.panamadakadithi));
        arrayList.add(new MusicHandler("Rahase Hadana","Api Machan",R.raw.rahasehandana));
        arrayList.add(new MusicHandler("Adaraye Unuhuma","Somathilaka Jayamaha",R.raw.adrayeunuhuma));
        arrayList.add(new MusicHandler("Apa Hamuweema","Namal Udugama",R.raw.aphamuweemawenweema));
        arrayList.add(new MusicHandler("Api Hagum Walata","Api Machan Cover",R.raw.apihangumwalata));

        musicAdapter = new MusicAdapter(this, R.layout.media_item, arrayList);
        songListView.setAdapter(musicAdapter);

        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(MediaListActivity.this, MediaItemPlay.class);
                intent.putExtra("SongName", arrayList.get(position).getName());
                intent.putExtra("SongID", arrayList.get(position).getSong());
                intent.putExtra("ArtistName", arrayList.get(position).getSingerName());
                MediaListActivity.this.startActivity(intent);

                Intent playBackServiceIntent = new Intent(MediaListActivity.this,MyBackgroundService.class);
                startService(playBackServiceIntent);
            }
        });
    }
}
