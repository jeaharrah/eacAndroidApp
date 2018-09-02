package com.example.jeaha.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent;
    Intent actionItem;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fabIncrease = findViewById(R.id.fabIncrease);
        fabIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setTextSize(pixelsToSp(MainActivity
                        .this, (textView
                        .getTextSize()) + 4));
            }
        });

        FloatingActionButton fabDecrease = findViewById(R.id.fabDecrease);
        fabDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setTextSize(pixelsToSp(MainActivity
                        .this, (textView
                        .getTextSize()) - 4));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        imageView = findViewById(R.id.eacLogoImageView);
        textView = findViewById(R.id.welcomeGreetingMsgTextView);

    }

    public static float pixelsToSp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return px / scaledDensity;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        /*else if (id == R.id.action_home) {
            actionItem = new Intent(MainActivity.this, MainActivity.class);
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            intent = new Intent(MainActivity.this, TabbedAbout.class);
            startActivity(intent);

        } else if (id == R.id.nav_ggrc) {
            intent = new Intent(MainActivity.this, GGRC.class);
            startActivity(intent);

        } else if (id == R.id.nav_programs) {
            intent = new Intent(MainActivity.this, Calendar.class);
            startActivity(intent);

        } else if (id == R.id.nav_contact) {
            intent = new Intent(MainActivity.this, Contact.class);
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {
            intent = new Intent(MainActivity.this, PhotoGallery.class);
            startActivity(intent);

        } else if (id == R.id.nav_like_us_on_fb) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Abington.EAC/"));
            startActivity(intent);

        } else if (id == R.id.nav_caption) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Abington" +
                    ".EAC/"));
            startActivity(intent);
        } else if (id == R.id.nav_chooser_signin) {
            intent = new Intent(MainActivity.this, ChooserActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_home) {
            intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
