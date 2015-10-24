package com.lucyreynolds.speedshop;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {
    private ArrayList<String> items;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    View view;
    private ActionBarDrawerToggle mDrawerToggle;

    CharSequence mTitle;
    CharSequence mDrawerTitle;
    ArrayAdapter myAdap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] temp = {"Milk","Turkey", "Toothpaste", "Apples"};
        items = new ArrayList<String>(Arrays.asList(temp));
        mTitle = mDrawerTitle = "";
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

                // Set the adapter for the list view
        myAdap = new ArrayAdapter<String>(this, R.layout.drawer_list_item, items);
        mDrawerList.setAdapter(myAdap);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);



        for (int i = 0; i < items.size(); i++) {
            String cur = items.get(i);

            switch (cur){
                case "Milk":
                    view = (View)findViewById(R.id.MilkImage);
                    view.setVisibility(View.VISIBLE);
                    break;
                case "Bread":
                    view = (View)findViewById(R.id.BreadImage);
                    view.setVisibility(View.VISIBLE);
                    break;
                case "Eggs":
                    view = (View)findViewById(R.id.EggsImage);
                    view.setVisibility(View.VISIBLE);
                    break;
                case "Apples":
                    view = (View)findViewById(R.id.ApplesImage);
                    view.setVisibility(View.VISIBLE);
                    break;
                case "Lettuce":
                    view = (View)findViewById(R.id.LettuceImage);
                    view.setVisibility(View.VISIBLE);
                    break;
                case "Turkey":
                    view = (View)findViewById(R.id.TurkeyImage);
                    view.setVisibility(View.VISIBLE);
                    break;
                case "Toothpaste":
                    view = (View)findViewById(R.id.ToothpasteImage);
                    view.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }

        }


        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            String str = items.get(position);
            items.remove(str);
            myAdap.notifyDataSetChanged();
            switch (str){
                case "Milk":
                    view = (View)findViewById(R.id.MilkImage);

                    break;
                case "Bread":
                    view = (View)findViewById(R.id.BreadImage);
                    break;
                case "Eggs":
                    view = (View)findViewById(R.id.EggsImage);
                    break;
                case "Apples":
                    view = (View)findViewById(R.id.ApplesImage);
                    break;
                case "Lettuce":
                    view = (View)findViewById(R.id.LettuceImage);
                    break;
                case "Turkey":
                    view = (View)findViewById(R.id.TurkeyImage);
                    break;
                case "Toothpaste":
                    view = (View)findViewById(R.id.ToothpasteImage);
                    break;
                default:
                    break;
            }
            int vis = view.getVisibility();
            if(vis == View.VISIBLE){
                view.setVisibility(View.INVISIBLE);
            }
            else {
                view.setVisibility(View.VISIBLE);
            }

        }
    }
}
