package com.example.jeaha.navigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

public class NavDrawerHelper extends ContextWrapper {

    Intent intent;

    public NavDrawerHelper(Context base) {
        super(base);
    }

    public void initNav(final DrawerLayout drawerLayout, NavigationView navigationView, Toolbar toolbar, final boolean isFinish) {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                switch (id) {
                    case R.id.nav_about:
                        intent = new Intent(getBaseContext(), TabbedAbout.class);
                        startActivity(intent);
                        if (isFinish) ((Activity) getBaseContext()).finish();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_programs:
                        intent = new Intent(getBaseContext(), Calendar.class);
                        startActivity(intent);
                        if (isFinish) ((Activity) getBaseContext()).finish();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_contact:
                        intent = new Intent(getBaseContext(), Contact.class);
                        startActivity(intent);
                        if (isFinish) ((Activity) getBaseContext()).finish();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_gallery:
                        intent = new Intent(getBaseContext(), PhotoGallery.class);
                        startActivity(intent);
                        if (isFinish) ((Activity) getBaseContext()).finish();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_like_us_on_fb:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Abington.EAC/"));
                        startActivity(intent);
                        if (isFinish) ((Activity) getBaseContext()).finish();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_caption:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Abington" +
                                ".EAC/"));
                        startActivity(intent);
                        if (isFinish) ((Activity) getBaseContext()).finish();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_chooser_signin:
                        intent = new Intent(getBaseContext(), ChooserActivity.class);
                        startActivity(intent);
                        if (isFinish) ((Activity) getBaseContext()).finish();
                        drawerLayout.closeDrawers();
                        break;

                }
                return true;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(((Activity)
                getBaseContext()), drawerLayout, toolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

}