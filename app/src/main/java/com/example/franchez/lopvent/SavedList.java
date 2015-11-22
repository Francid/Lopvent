package com.example.franchez.lopvent;

import java.util.Locale;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class SavedList extends AppCompatActivity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_list);

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }


    }

    public static class EventCursorAdapter extends CursorAdapter {
        public EventCursorAdapter(Context context, Cursor cursor) {
            super(context, cursor);
        }

        // The newView method is used to inflate a new view and return it,
        // you don't bind any data to the view at this point.
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.savedeventlist, parent, false);
        }

        // The bindView method is used to bind all data to a given view
        // such as setting the text on a TextView.
        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            // Find fields to populate in inflated template
            TextView eName= (TextView) view.findViewById(R.id.save_eName);
            TextView date = (TextView) view.findViewById(R.id.save_date);
            TextView time = (TextView) view.findViewById(R.id.save_time);
            TextView price = (TextView) view.findViewById(R.id.save_price);
            TextView description = (TextView) view.findViewById(R.id.save_desc);
            TextView location = (TextView) view.findViewById(R.id.save_location);
            //ImageView pic = (ImageView) view.findViewById(R.id.save_pic);

            // Extract properties from cursor
            String ENAME = cursor.getString(cursor.getColumnIndex("E_NAME"));
            String DATE = cursor.getString(cursor.getColumnIndex("DATE"));
            String TIME = cursor.getString(cursor.getColumnIndex("TIME"));
            String PRICE = cursor.getString(cursor.getColumnIndex("PRICE"));
            String DESCRIPTION = cursor.getString(cursor.getColumnIndex("DESCRIPTION"));
            String LOCATION = cursor.getString(cursor.getColumnIndex("LOCATION"));
            //String PICTURE = cursor.getString(cursor.getColumnIndex("PICTURE"));
            // Populate fields with extracted properties
            eName.setText(ENAME);eName.setTextColor(Color.RED);
            date.setText("DATE:" +DATE);date.setTextColor(Color.RED);
            time.setText("TIME:" + TIME);time.setTextColor(Color.RED);
            price.setText("PRICE:" + PRICE);price.setTextColor(Color.RED);
            description.setText("DESCRIPTION:" + DESCRIPTION);description.setTextColor(Color.RED);
            location.setText("LOCATION:" + LOCATION);location.setTextColor(Color.RED);
//            pic.setImageURI(Uri.parse(PICTURE));



        }

    }

    public static class PlaceCursorAdapter extends CursorAdapter {
        public PlaceCursorAdapter(Context context, Cursor cursor) {
            super(context, cursor);
        }

        // The newView method is used to inflate a new view and return it,
        // you don't bind any data to the view at this point.
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.saveplacelist, parent, false);
        }

        // The bindView method is used to bind all data to a given view
        // such as setting the text on a TextView.
        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            // Find fields to populate in inflated template
            TextView pName= (TextView) view.findViewById(R.id.save_plcName);
            TextView description = (TextView) view.findViewById(R.id.save_plcdesc);
            TextView location = (TextView) view.findViewById(R.id.save_plclocation);
            //ImageView pic = (ImageView) view.findViewById(R.id.save_pic);

            // Extract properties from cursor
            String PNAME = cursor.getString(cursor.getColumnIndex("P_NAME"));
            String DESCRIPTION = cursor.getString(cursor.getColumnIndex("DESCRIPTION"));
            String LOCATION = cursor.getString(cursor.getColumnIndex("LOCATION"));
            //String PICTURE = cursor.getString(cursor.getColumnIndex("PICTURE"));
            // Populate fields with extracted properties
            pName.setText(PNAME);pName.setTextColor(Color.RED);
            description.setText("DESCRIPTION:" + DESCRIPTION);description.setTextColor(Color.RED);
            location.setText("LOCATION:" + LOCATION);location.setTextColor(Color.RED);
//            pic.setImageURI(Uri.parse(PICTURE));



        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saved_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if (position==0) {
                return EventFragment.newInstance(1);
            }
            if(position==1) {
                return PlaceFragment.newInstance(1);
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);

            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class EventFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        //private ListView EventListView=(ListView) findViewById(R.id.EventlistView);;
        private Cursor  cursor;
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static EventFragment newInstance(int sectionNumber) {
            EventFragment fragment = new EventFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public EventFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_saved_list, container, false);

            DatabaseHelper mydb=new DatabaseHelper(getActivity());
            cursor=mydb.getEvent();
            EventCursorAdapter saveAdapter = new EventCursorAdapter(getActivity().getApplicationContext(),cursor);
            ListView EventListView=(ListView) rootView.findViewById(R.id.EventlistView);
            EventListView.setAdapter(saveAdapter);

            return rootView;
        }

    }
    public static class PlaceFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        //private ListView EventListView=(ListView) findViewById(R.id.EventlistView);;
        private Cursor  cursor;
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceFragment newInstance(int sectionNumber) {
            PlaceFragment fragment = new PlaceFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_saved_list2, container, false);

            DatabaseHelper mydb=new DatabaseHelper(getActivity());
            cursor=mydb.getPlace();
            PlaceCursorAdapter saveAdapter = new PlaceCursorAdapter(getActivity().getApplicationContext(),cursor);
            ListView PlaceListView=(ListView) rootView.findViewById(R.id.PlacelistView);
            PlaceListView.setAdapter(saveAdapter);

            return rootView;
        }

    }

}
