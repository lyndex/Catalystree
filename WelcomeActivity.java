package com.example.catalystreeapp.Level2Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.catalystreeapp.Level3Fragment.FCar;
import com.example.catalystreeapp.R;

public class FTransportation extends Fragment {

    Button Bcar, Btransit, Bwalk;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_transportation, container, false);
        Bcar = (Button) myView.findViewById(R.id.b_car);
        Bcar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Fragment newFragment = new FCar();
                                        FragmentTransaction transaction = getFragmentManager().beginTransaction();

                                        transaction.replace(R.id.fragment_car, newFragment);
                                        transaction.addToBackStack(null);

                                        transaction.commit();
                                    }});
//
//            Btransit = (Button) myView.findViewById(R.id.b_transit);
//            Btransit.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Fragment newFragment = new FCar();
//                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//                    transaction.replace(R.id.fragment_car, newFragment);
//                    transaction.addToBackStack(null);
//
//                    transaction.commit();
//                }}
//
//        Bwalk = (Button) myView.findViewById(R.id.b_walk);
//        Btransit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment newFragment = new FCar();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//                transaction.replace(R.id.fragment_car, newFragment);
//                transaction.addToBackStack(null);
//
//                transaction.commit();
//            }}
        return myView;
    }


}
