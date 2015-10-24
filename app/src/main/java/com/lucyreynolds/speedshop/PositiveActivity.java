package com.lucyreynolds.speedshop;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class PositiveActivity extends Activity {
    ArrayList<String> sel = new ArrayList<>();
    ArrayList<Integer> selInd;
    String[] database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database = getResources().getStringArray(R.array.shopping_list);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positive);
        alertMultipleChoiceItems();
    }
    public void alertMultipleChoiceItems(){

        // where we will store or remove selected items
        selInd = new ArrayList<Integer>();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // set the dialog title
        builder.setTitle("Select Groceries")

                // specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive call backs when items are selected
                // R.array.choices were set in the resources res/values/strings.xml
                .setMultiChoiceItems(R.array.shopping_list, null, new DialogInterface.OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        if (isChecked) {
                            // if the user checked the item, add it to the selected items
                            selInd.add(which);
                        }

                        else if (selInd.contains(which)) {
                            // else if the item is already in the array, remove it
                            selInd.remove(Integer.valueOf(which));
                        }

                        // you can also add other codes here,
                        // for example a tool tip that gives user an idea of what he is selecting
                        // showToast("Just an example description.");
                    }

                })

                        // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        // user clicked OK, so save the mSelectedItems results somewhere
                        // here we are trying to retrieve the selected items indices
                        for(Integer i : selInd){
                            sel.add(database[i]);
                        }
                        Intent intent = new Intent(PositiveActivity.this, MainActivity.class);
                        intent.putStringArrayListExtra("sel",sel);
                        startActivity(intent);
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
