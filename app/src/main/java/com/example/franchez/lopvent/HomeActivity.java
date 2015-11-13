package com.example.franchez.lopvent;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.SortedMap;
import java.util.TreeMap;

 public class HomeActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
  }






     public void gotoNavigationPage(View view) {
         Intent intent=new Intent(this,navigation.class);
         startActivity(intent);
     }
 }
