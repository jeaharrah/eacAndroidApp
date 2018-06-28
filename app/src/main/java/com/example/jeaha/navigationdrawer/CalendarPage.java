package com.example.jeaha.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class CalendarPage extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter adapter;

    List<Item> itemList;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adding some items to our list
        itemList.add(new Item("Creek Cleanup", "Community Service", "Pennypack Watershed",
                "9:00 am", "July", "2", "Monday"));

        itemList.add(
                new Item("Tree Planting Workshop", "Educational Program", "Briarwood Nature " +
                        "Center",
                        "10:00 am", "July", "21", "Saturday"));

        itemList.add(
                new Item("Abington EAC Committee Meeting", "Township Affairs", "Town Hall of " +
                        "Abington Township", "7:00 pm", "July", "11", "Wednesday"));

        //creating RecyclerView adapter
        ItemAdapter adapter = new ItemAdapter(this, itemList);

        //setting adapter to RecyclerView
        recyclerView.setAdapter(adapter);

        calendar = Calendar.getInstance();

        String in = "";
        JSONObject reader = null;
        JSONObject eventA = null;

        String title = "";
        String shortDescription = "";
        String location = "";
        String month = "";
        String date = "";
        String weekday = "";
        String time = "";

        try {
            reader = new JSONObject(in);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            eventA = reader.getJSONObject("eventA");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            title = eventA.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            shortDescription = eventA.getString("shortDescription");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            location = eventA.getString("location");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            month = eventA.getString("month");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            date = eventA.getString("date");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            weekday = eventA.getString("weekday");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            time = eventA.getString("time");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
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

    ArrayList<String> items;

    public void getEventItem() {
        items = new ArrayList<>();

        for (int i = 1; i <= items.size(); i++) {

        }

    }

}
