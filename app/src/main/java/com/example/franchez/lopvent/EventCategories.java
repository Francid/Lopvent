package com.example.franchez.lopvent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class EventCategories extends AppCompatActivity {
private static Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_categories);
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        intent=new Intent(this,EventList.class);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(EventCategories.this, "" + position,
                        Toast.LENGTH_SHORT).show();
               // gotoEventList(position);
                String nameEvent = String.valueOf(gridview.getItemAtPosition(position));
                intent.putExtra("keyEventName", nameEvent);
                startActivity(intent);
            }
        });
    }


}
