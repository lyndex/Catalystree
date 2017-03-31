package com.example.catalystreeapp.Main;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.catalystreeapp.Level1Fragment.FHome;
import com.example.catalystreeapp.Level1Fragment.FInput;
import com.example.catalystreeapp.Level1Fragment.FProfile;
import com.example.catalystreeapp.Level1Fragment.FSettings;
import com.example.catalystreeapp.Level1Fragment.FUsage;
import com.example.catalystreeapp.R;

public class MainActivity extends AppCompatActivity{

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         setContentView(R.layout.activity_main);

//        set default displayed fragment
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content_frame, new FHome());
        tx.commit();

        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        String s = getIntent().getStringExtra("USERNAME_KEY");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("USERNAME_KEY");
            //The key argument here must match that used in the other activity
        }

//        SharedPreferences sharedPreferences = getSharedPreferences("your_preferences", Activity.MODE_PRIVATE);
//        String currentUsername = sharedPreferences.getString("USERNAME_KEY", userName);

//        Bundle bundle = new Bundle();
//        bundle.getString("USERNAME_KEY", userName);
// set Fragment class Arguments
        FProfile frag = new FProfile();
        frag.setArguments(extras);

        setupToolbar();

        DataModel[] drawerItem = new DataModel[5];

        drawerItem[0] = new DataModel(R.drawable.ic_home, "Home");
        drawerItem[1] = new DataModel(R.drawable.ic_profile, "Profile");
        drawerItem[2] = new DataModel(R.drawable.ic_input, "Input");
        drawerItem[3] = new DataModel(R.drawable.ic_usage, "Usage");
        drawerItem[4] = new DataModel(R.drawable.ic_settings, "Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

//links to the drawer items
    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new FHome();
                break;
            case 1:
                fragment = new FProfile();

                break;
            case 2:
                fragment = new FInput();
                break;
            case 3:
                fragment = new FUsage();
                break;
            case 4:
                fragment = new FSettings();
                break;

            default:
                break;
        }

        if (fragment != null) {

//            supposed to fix the get intent in PFragment
            FProfile frag = new FProfile();
            frag.setArguments(getIntent().getExtras());

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

//    allows user to return to previous fragment when back is pressed
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}