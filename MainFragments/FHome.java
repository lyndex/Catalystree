package com.example.catalystreeapp.MainFragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.catalystreeapp.R;

public class FHome extends Fragment {

    AnimationDrawable neutral_idle;

    public FHome() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView pandaImage = (ImageView) rootView.findViewById(R.id.pandaView);
        pandaImage.setBackgroundResource(R.drawable.neutral_idle);
        neutral_idle = (AnimationDrawable) pandaImage.getBackground();
        neutral_idle.start();

        return rootView;
    }
}
