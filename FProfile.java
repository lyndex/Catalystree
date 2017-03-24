package com.example.catalystreeapp.Level1Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.catalystreeapp.R;

public class FProfile extends Fragment {

    public FProfile() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        String username = getActivity().getIntent().getStringExtra("USERNAME_KEY");

        TextView textView = (TextView) getActivity().findViewById(R.id.TVDisplayUsername);
        textView.setText(username);

        return rootView;
    }
}

