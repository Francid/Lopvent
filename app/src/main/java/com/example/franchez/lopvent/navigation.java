package com.example.franchez.lopvent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Owner on 2015-11-13.
 */
public class navigation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }

//@ Avneet: goto SAved Event List which will populate popular, nearby and  ALL Events
    public void gotoEventCategory(View view) {
Intent intent ;
        intent = new Intent(this, EventCategories.class);
        startActivity(intent);

    }

    public void kill(View view) {
        finish();
    }
}
