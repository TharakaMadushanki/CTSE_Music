package com.sliit.tharaka.unimusicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;

import java.util.ArrayList;

/**
 * Created by ASUS on 3/31/2018.
 */

public class MediaListActivity extends Activity {

    private ArrayList<MusicHandler> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_item_list);



    }

}
