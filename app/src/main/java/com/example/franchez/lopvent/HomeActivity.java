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

import java.util.SortedMap;
import java.util.TreeMap;

 public class HomeActivity extends Activity {

private  static Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        intent = new Intent(this, EventList.class);
        String[] namesArray = {"Top Event1", "Top Event2",
                "Top Event3" };

        ArrayAdapter<String> theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, namesArray);


        ListView ListView = (ListView) findViewById(R.id.listview);
        ListView.setAdapter(theAdapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nameEvent = String.valueOf(adapterView.getItemAtPosition(i));
                intent.putExtra("keyEventName", nameEvent);
                startActivity(intent);


            }
        });
  }






     public void gotoNavigationPage(View view) {
         Intent intent=new Intent(this,navigation.class);
         startActivity(intent);
     }
 }
