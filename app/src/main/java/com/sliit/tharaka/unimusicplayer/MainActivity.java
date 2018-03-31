package com.sliit.tharaka.unimusicplayer;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "mainActivity";
    private ArrayList<MusicHandler> arrayList;
    private ListView songListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songListView = (ListView) findViewById(R.id.song_list);
        arrayList = new ArrayList<>();
        arrayList.add(new MusicHandler("Idoraye Nagara Kone", "Amal Perera", R.raw.idorayenagarakone));
        arrayList.add(new MusicHandler("Mal Pita Mal", "Amal Perera Cover", R.raw.malpitamal));
        arrayList.add(new MusicHandler("Ran Meevitha", "Amal Perera", R.raw.ranmeevitha));
        arrayList.add(new MusicHandler("Sanda Midulata Enawa", "Amal Perera Cover", R.raw.sandamidulataenawa));

//        Button button = (Button) findViewById(R.id.btnAllSongs);
//        button.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//
//
//                Intent intent = new Intent(MainActivity.this, MediaListActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putParcelableArrayList("mylist", (ArrayList<? extends Parcelable>) arrayList);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });

    }
}
