package com.lucyreynolds.speedshop;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class MapActivityFragment extends Fragment {


    public MapActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }
    public class MyActivity extends Activity {
        protected void onCreate(Bundle icicle) {
            super.onCreate(icicle);

            setContentView(R.layout.fragment_map);

            final Button button = (Button) findViewById(R.id.icon);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {


                    
                }
            });

        }
    }
}
