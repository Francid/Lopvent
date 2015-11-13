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
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(EventCategories.this, "" + position,
                        Toast.LENGTH_SHORT).show();
                gotoEventList(position);
            }
        });
    }

    private void gotoEventList(int position) {

        switch (position){
            case 1:
                intent=new Intent(this,EventList.class);
                intent.putExtra("event1","event1");
                break;
            case 2:
                intent=new Intent(this,EventList.class);
                intent.putExtra("event2","event2");
                break;
            case 3:
                intent=new Intent(this,EventList.class);
                intent.putExtra("event3","event3");
                break;
            case 4:
                intent=new Intent(this,EventList.class);
                intent.putExtra("event4","event4");
                break;
            case 5:
                intent=new Intent(this,EventList.class);
                intent.putExtra("event5","event5");
                break;
            case 6:
                intent=new Intent(this,EventList.class);
                intent.putExtra("event6","event6");
                break;

        }
        startActivity(intent);
    }
}
