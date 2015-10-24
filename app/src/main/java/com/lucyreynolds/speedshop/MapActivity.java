package com.lucyreynolds.speedshop;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MapActivity extends ActionBarActivity {
    private String[] items;
    View view;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        items = new String[]{"Milk","Turkey", "Toothpaste", "Apples"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        for (int i = 0; i < items.length; i++) {
            String cur = items[i];

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
