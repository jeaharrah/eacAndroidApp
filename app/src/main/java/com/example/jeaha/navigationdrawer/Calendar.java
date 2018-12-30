package com.example.jeaha.navigationdrawer;

import android.content.Intent;
import android.content.res.AssetManager;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


public class Calendar extends AppCompatActivity {

    Intent intent;

    RecyclerView recyclerView;
    ItemAdapter adapter;

    List<Item> itemList;

    String title = "";
    String shortDescription = "";
    String location = "";
    String month = "";
    String date = "";
    String weekday = "";
    String time = "";
    String year = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Calendar.this, Contact.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            try {
                itemList = getEventItem("events");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }

        //Creating RecyclerView adapter
        adapter = new ItemAdapter(this, itemList);

        //setting adapter to RecyclerView
        recyclerView.setAdapter(adapter);

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

    public List<Item> getEventItem(String in) throws JSONException, IOException {
        InputStream inputStream;
        AssetManager assetManager = getAssets();
        inputStream = assetManager.open("events_list.json");

        String jsonString = getStringFromInputStream(inputStream, "UTF-8");
        JSONObject json = new JSONObject(jsonString);
        JSONArray jArray = json.getJSONArray(in);
        JSONObject e;

        System.out.println("JSON Array Length: " + jArray.length());

        for (int i = 0; i < jArray.length(); i++) {
            e = jArray.getJSONObject(i);

            title = e.getString("title");
            shortDescription = e.getString("shortDescription");
            location = e.getString("location");
            time = e.getString("time");
            month = e.getString("month");
            date = e.getString("date");
            weekday = e.getString("weekday");
            year = e.getString("year");

            Item item = new Item(title, shortDescription, location, time, month, date, weekday,
                    year);
            itemList.add(item);

        }

        return itemList;

    }

    public static String getStringFromInputStream(InputStream stream, String charsetName) throws IOException {
        int n = 0;
        char[] buffer = new char[1024 * 4];

        InputStreamReader reader = new InputStreamReader(stream, charsetName);
        StringWriter writer = new StringWriter();

        while (-1 != (n = reader.read(buffer)))
            writer.write(buffer, 0, n);

        return writer.toString();
    }

}
