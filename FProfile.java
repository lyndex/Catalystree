package com.example.catalystreeapp.Level1Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catalystreeapp.R;

public class FProfile extends Fragment {
String currentUser;
    public FProfile() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

//        fetch username TODO fix this pls
        currentUser = getActivity().getIntent.getStringExtra("Username");

        return rootView;
    }
}

