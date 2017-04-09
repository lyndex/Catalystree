package com.example.catalystreeapp.MainFragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.catalystreeapp.R;
import com.example.catalystreeapp.Transportation.CarDataBaseAdapter;
import com.example.catalystreeapp.Transportation.CarDataBaseHelper;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FUsageEnergyW extends Fragment {

    private static String TAG = "Energy Weekly Graph";
    LineChart linechart;
    CarDataBaseAdapter carDataBaseAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_usage_energy, container, false);
        Log.d(TAG, "onCreate: starting to create line chart");
//        xml
        linechart = (LineChart) myView.findViewById(R.id.linechart_energy);
        Intent intent = getActivity().getIntent();
//        passed username used to identify user
        String username = intent.getStringExtra("USERNAME_KEY");

//        convert cursor to array
        Cursor c = carDataBaseAdapter.getCarEntry(username);
        int count = 7;

        String[] date = new String[count];
        Integer[] distance = new Integer[count];

        int m;
        for (m = 0; m < count; m++) {
            c.moveToNext();
            date[m] = c.getString(0);
            distance[m] = c.getInt(1);
        }
        c.close();

//        create array for y values
        ArrayList<Entry> yVals = new ArrayList<Entry>();

        for (int i = 0; i < date.length; i++) {
            yVals.add(new Entry((float) distance[i], i));
        }
        
//        create array for x values
        final ArrayList<String> xVals = new ArrayList<String>();
        
        for (int i = 0; i < date.length; i++)
            xVals.add(date[m % date.length]);

//        creating dataset
        LineDataSet set1 = new LineDataSet(yVals, "Energy Consumed(kJ)");
        LineData data = new LineData(set1);

//        formatting so that strings can be displayed on the x axis
        XAxis xAxis = linechart.getXAxis();
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                return xVals.get((int) value);
            }
        });
        linechart.setData(data);
        linechart.invalidate();

        return myView;
    }
}
