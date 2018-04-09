package com.sliit.tharaka.unimusicplayer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sliit.tharaka.unimusicplayer.model.MusicHandler;

/**
 * Created by ASUS on 4/9/2018.
 */

public class FragmentPlay extends Fragment {

    private MusicHandler song = new MusicHandler();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_play, container, false);

    }
}
