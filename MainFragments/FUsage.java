package com.example.catalystreeapp.MainFragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catalystreeapp.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class FUsage extends Fragment {

    int Transportation, ClimateControl, Household;

    private static String TAG = "DailyGraph";
    private float[] yData = {Transportation, ClimateControl, Household};
    private String[] xData = {"Transportation", "Climate Control", "Household"};
    //    declare pie chart as global variable
    PieChart pieChart;

    public FUsage() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_usage, container, false);
//      setContentView(R.layout.daily graph);
        Log.d(TAG, "onCreate: starting to create chart");

        pieChart = (PieChart) myView.findViewById(R.id.PieChart);

//        pieChart.setDescription("Energy Usage by Sector");
//        enable pie chart rotation
        pieChart.setRotationEnabled(true);

//        add data to the chart
        addDataSet();

        return myView;
    }

    private void addDataSet() {
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntries = new ArrayList<>();
        ArrayList<String> xEntries = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            yEntries.add(new PieEntry(yData[i], i));
        }
        for(int i = 1; i < xData.length; i++){
            xEntries.add(xData[i]);
        }
//      create data set
        PieDataSet pieDataSet = new PieDataSet(yEntries, "items");
        pieDataSet.setSliceSpace(1);
        pieDataSet.setValueTextSize(12);

//      add colors
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.MAGENTA);
        colors.add(Color.GRAY);
        colors.add(Color.GREEN);

        pieDataSet.setColors(colors);

//        add legend
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);
        legend.setTextColor(Color.WHITE);

//        create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
