package com.example.catalystreeapp;

//this is for energy usage pie chart


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UsageGraph extends Activity {

    private TextView txtinfo;
    LinearLayout lvOne, lvTwo, lvThree, lvFour, lvparent;
    TextView txtOne, txtTwo, txtThree, txtFour;
    Button btnweekly, btntips;
    PieView pieView;
    //Uri outputFileUri;
   // OutputStream outStream = null;
    String[] sectors = new String[] { "Transportation", "Climate Control", "Household", "Devices"};
    int[] percentage = new int[] { 55, 25, 10, 10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usage_graph);

        txtinfo = (TextView) findViewById(R.id.txtinfo);
        pieView = (PieView) findViewById(R.id.pie_view);

        lvOne = (LinearLayout) findViewById(R.id.lvOne);
        lvTwo = (LinearLayout) findViewById(R.id.lvTwo);
        lvThree = (LinearLayout) findViewById(R.id.lvThree);
        lvFour = (LinearLayout) findViewById(R.id.lvFour);
        lvparent = (LinearLayout) findViewById(R.id.lvparent);

        txtOne = (TextView) findViewById(R.id.txtOne);
        txtTwo = (TextView) findViewById(R.id.txtTwo);
        txtThree = (TextView) findViewById(R.id.txtThree);
        txtFour = (TextView) findViewById(R.id.txtFour);

        btnweekly = (Button) findViewById(R.id.btnweekly);
        btntips = (Button) findViewById(R.id.btntips);

       // btntips.setOnClickListener(new View.OnClickListener() {
//

    private void set(PieView pieView) {

        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<PieHelper>();

        int color0 = Color.rgb(0, 128, 255);
        int color1 = Color.rgb(252, 3, 71);
        int color2 = Color.rgb(117, 91, 4);
        int color3 = Color.rgb(3, 7, 173);
        int color4 = Color.rgb(20, 156, 82);

        pieHelperArrayList.add(new PieHelper(55, color0))
        ;
        pieHelperArrayList.add(new PieHelper(25, color1));

        pieHelperArrayList.add(new PieHelper(10, color2));

        pieHelperArrayList.add(new PieHelper(10, color3));


        lvOne.setBackgroundColor(color0);
        txtOne.setText(sectors[0]);
        lvTwo.setBackgroundColor(color1);
        txtTwo.setText(sectors[1]);
        lvThree.setBackgroundColor(color2);
        txtThree.setText(sectors[2]);
        lvFour.setBackgroundColor(color3);
        txtFour.setText(sectors[3]);

        pieView.setDate(pieHelperArrayList);
        pieView.setOnPieClickListener(new PieView.OnPieClickListener() {
            @Override
            public void onPieClick(int index) {
                if (index != PieView.NO_SELECTED_INDEX) {
                    txtinfo.setText(percentage[index] + "% uses "
                            + sectors[index] + ".");
                } else {
                    txtinfo.setText("Nothing selected");
                }
            }
        });
    }
}
