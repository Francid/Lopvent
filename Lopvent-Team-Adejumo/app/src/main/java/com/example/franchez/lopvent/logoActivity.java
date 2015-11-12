package com.example.franchez.lopvent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Owner on 2015-11-11.
 */
public class logoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
    }

    public void gotoSetLocation(View view) {
        Intent intent =new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}
