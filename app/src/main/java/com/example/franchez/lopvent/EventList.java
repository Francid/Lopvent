package com.example.franchez.lopvent;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


public class EventList extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        TabHost tabHost = getTabHost();

        /* Create All_View Tab*/
        TabSpec tabSpecAllView = tabHost.newTabSpec("ALL")
                .setIndicator("ALL")
                .setContent(new Intent(this, All_View.class));

        /* Create Popular_View Tab*/
        TabSpec tabSpecPopularView = tabHost.newTabSpec("Popular")
                .setIndicator("POPULAR")
                .setContent(new Intent(this,Popular_View.class));

        /*Create Nearby_View Tab*/
        TabSpec tabSpecNearbyView = tabHost.newTabSpec("Nearby")
                .setIndicator("NEARBY")
                .setContent(new Intent(this,Nearby_View.class));

        /*Add all tab*/
        tabHost.addTab(tabSpecAllView);
        tabHost.addTab(tabSpecPopularView);
        tabHost.addTab(tabSpecNearbyView);

        /*Set current tab to be AllView*/
        tabHost.setCurrentTab(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_view, menu);
        return true;
    }
}
