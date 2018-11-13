package com.example.jeaha.navigationdrawer;


//https://github.com/cuttingedge03/NavigationDrawer

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class BaseActivity extends AppCompatActivity { //changed from deprecated ActionBarActivity
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    protected RelativeLayout _completeLayout, _activityLayout;
    // Nav Drawer title
    private CharSequence mDrawerTitle;
    private Menu menuObject;
    // App title
    private CharSequence mTitle;
    Toolbar toolbar;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);
        if (savedInstanceState == null) {
            // On first time display view for first nav item
            displayView(0);
        }
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

        // Setting the Nav Drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // Enabling action bar app icon and setting it to behave as a toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setupDrawerToggle();

        getSupportActionBar().setIcon(R.drawable.ic_drawer);
        mDrawerToggle.syncState();

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, // nav menu toolbar instead of icon
                R.string.navigation_drawer_open, // nav drawer open - description for accessibility
                R.string.navigation_drawer_close // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                supportInvalidateOptionsMenu();
                mDrawerToggle.syncState();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                supportInvalidateOptionsMenu();
                //mDrawerToggle.syncState();
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);

    }

    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // Display view for selected nav drawer item
            displayView(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getSupportMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * Displaying fragment view for selected Nav Drawer list item
     */
    private void displayView(int position) {

        switch (position) {
            //nav_about
            case 0:
                Intent intent = new Intent(getBaseContext(), TabbedAbout.class);
                startActivity(intent);
                finish();
                break;

            //nav_ggrc
            case 1:
                Intent intent1 = new Intent(getBaseContext(), GGRC.class);
                startActivity(intent1);
                finish();
                break;

            //nav_programs
            case 2:
                Intent intent2 = new Intent(getBaseContext(), Calendar.class);
                startActivity(intent2);
                finish();
                break;

            //nav_contact
            case 3:
                Intent intent3 = new Intent(getBaseContext(), Contact.class);
                startActivity(intent3);
                finish();
                break;

            //nav_gallery
            case 4:
                Intent intent4 = new Intent(getBaseContext(), PhotoGallery.class);
                startActivity(intent4);
                finish();
                break;

            //nav_like_us_on_fb
            case 5:
                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www" +
                        ".facebook.com/Abington.EAC/"));
                startActivity(intent5);
                finish();
                break;

            default:
                break;
        }


        // update selected item and title, then close the drawer
       /* for (int i = 0; i <= mDrawerList.getAdapter().getCount(); i++) {
            if (position == i) {*/
        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);
//            } else {
        mDrawerLayout.openDrawer(mDrawerList, true);
        //}
        //}

        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during onPostCreate() and
     * onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    void setupDrawerToggle() {
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }
}