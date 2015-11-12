package com.example.franchez.lopvent;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.SortedMap;
import java.util.TreeMap;

 public class HomeActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String[] arrayEvents=getResources().getStringArray(R.array.TopEvents);
        Spinner spinner=new Spinner(this);
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                arrayEvents);
        spinner.setAdapter(spinnerArrayAdapter);
        // Inflate the menu; this adds items to the action bar if it is present.
    }

    public void gotoNavigationPane(View view) {
        Intent intent=new Intent(this,NavigationMenuPage.class);
        startActivity(intent);
    }
}
