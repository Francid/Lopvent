package com.example.franchez.lopvent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
//navigate to setLocation page
    public void gotoSetLocation(View view) {
        Intent gotoSetLocationIntent=new Intent(this,SetLocation.class);
        startActivity(gotoSetLocationIntent);
        Intent intent =new Intent(this,SetLocation.class);
      //  startActivity(intent);
    }
}
