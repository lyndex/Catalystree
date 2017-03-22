package com.example.catalystreeapp.Level1Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import com.example.catalystreeapp.Level2Fragment.FCar;
import com.example.catalystreeapp.Level2Fragment.FTransportation;
import com.example.catalystreeapp.Level3Fragment.FCar;
import com.example.catalystreeapp.R;

public class FInput extends Fragment {

    Button transportationButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_input, container, false);
        transportationButton = (Button) myView.findViewById(R.id.transportation_button);
        transportationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new FTransportation();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_transportation, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });
        return myView;
        }
}
