package com.example.piecharttutorial;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    private float[] yData = {25.3f, 10.6f, 66.76f};
    private String[] xData = {"frozen cod", "six", "stool"};
//    declare piechart as global variable
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starting to create chart");

        pieChart = (PieChart) findViewById(R.id.PieChart);

//        pieChart.setDescription("Energy Usage by Sector");
//        enable piechart rotation
        pieChart.setRotationEnabled(true);


//        add data to the chart
        addDataSet();
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

//        create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
