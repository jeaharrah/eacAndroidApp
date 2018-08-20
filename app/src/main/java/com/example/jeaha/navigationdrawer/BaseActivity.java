package com.example.jeaha.navigationdrawer;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    protected RelativeLayout _completeLayout, _activityLayout;

    // Nav Drawer title
    private CharSequence mDrawerTitle;

    // App title
    private CharSequence mTitle;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);

    }

    public void set(String[] navMenuTitles, String[] navMenuCaptions, TypedArray navMenuIcons) {
        mTitle = mDrawerTitle = getTitle();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        // Adding Nav Drawer items
        if (navMenuIcons == null) {
            for (int i = 0; i < navMenuTitles.length; i++) {
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[i], navMenuCaptions[i]));

            }
        } else {
            for (int i = 0; i < navMenuTitles.length; i++) {
                navDrawerItems.add(new NavDrawerItem(navMenuTitles[i], navMenuCaptions[i],
                        navMenuIcons.getResourceId
                                (i, -1)));
            }
        }

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());


    }


    private class SlideMenuClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Display view for selected nav drawer item

            displayView(position);
        }

        private void displayView(int position) {

            switch (position) {
                //nav_about
                case 0:
                    Intent intent = new Intent(getBaseContext(), TabbedAbout.class);
                    startActivity(intent);

                    //nav_ggrc
                case 1:
                    Intent intent1 = new Intent(getBaseContext(), GGRC.class);
                    startActivity(intent1);

                    //nav_programs
                case 2:
                    Intent intent2 = new Intent(getBaseContext(), Calendar.class);
                    startActivity(intent2);

                    //nav_contact
                case 3:
                    Intent intent3 = new Intent(getBaseContext(), Contact.class);
                    startActivity(intent3);

                    //nav_gallery
                case 4:
                    Intent intent4 = new Intent(getBaseContext(), PhotoGallery.class);
                    startActivity(intent4);

                    //nav_like_us_on_fb
                case 5:
                    Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www" +
                            ".facebook.com/Abington.EAC/"));
                    startActivity(intent5);

                    //nav_chooser_signin
                case 6:
                    Intent intent6 = new Intent(getBaseContext(), ChooserActivity.class);
                    startActivity(intent6);


            }

        }
    }
}
