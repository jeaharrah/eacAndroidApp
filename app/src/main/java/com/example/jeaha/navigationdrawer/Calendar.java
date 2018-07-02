package com.example.jeaha.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

public class Calendar extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter adapter;

    List<Item> itemList;
    List<Item> readStreamList;

    String in = "";
//    JSONObject reader = null;
//    JsonReader rdr = null;

    //
    ArrayList<String> itemsArrayList;
    JSONArray items;
    JSONObject e;

    String title = "";
    String shortDescription = "";
    String location = "";
    String month = "";
    String date = "";
    String weekday = "";
    String time = "";

    FileInputStream fis = null;
    InputStream is;

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
        /*itemList.add(new Item("Creek Cleanup", "Community Service", "Pennypack Watershed",
                "9:00 am", "July", "2", "Monday"));

        itemList.add(
                new Item("Tree Planting Workshop", "Educational Program", "Briarwood Nature " +
                        "Center",
                        "10:00 am", "July", "21", "Saturday"));

        itemList.add(
                new Item("Abington EAC Committee Meeting", "Township Affairs", "Town Hall of " +
                        "Abington Township", "7:00 pm", "July", "11", "Wednesday"));*/

        try {
            fis = new FileInputStream("res/events_list.json");
        } catch (FileNotFoundException e1) {
            System.out.println("Error locating events_list.json file: ");
            e1.printStackTrace();
        }

        is = fis;

/*        try {
            readJsonStream(is);
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/

/*        try {
            readStreamList = readJsonStream(is);
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/

//        try {
//            items = reader.getJSONArray("events");
//        } catch (JSONException e1) {
//            e1.printStackTrace();
//        }
//        for (int i = 0; i < items.length(); i++) {
//
//            try {
//                e = items.getJSONObject(i);
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
//
//            try {
//                title = e.getString("title");
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
//            try {
//                shortDescription = e.getString("shortDescription");
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
//            try {
//                location = e.getString("location");
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
//            try {
//                time = e.getString("time");
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
//            try {
//                month = e.getString("month");
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
//            try {
//                date = e.getString("date");
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
//            try {
//                weekday = e.getString("weekday");
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
//
//            Item item = new Item(title, shortDescription, location, time, month, date, weekday);
//            itemList.add(item);
//
//        }

        try {
            readStreamList = readJsonStream(is);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //Creating RecyclerView adapter
        //ItemAdapter adapter = new ItemAdapter(this, itemList);
        adapter = new ItemAdapter(this, readStreamList);

/*        try {
            fis.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/

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


    /*protected void getEventItem() throws JSONException {
        itemsArrayList = new ArrayList<>();

        for (int i = 1; i <= itemsArrayList.size(); i++) {

        }

        File file = new File("events_list.json");

        try {
            reader = new JSONObject(in);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        items = reader.getJSONArray("events");
        for (int i = 0; i < items.length(); i++) {

            e = items.getJSONObject(i);

            title = e.getString("title");
            shortDescription = e.getString("shortDescription");
            location = e.getString("location");
            time = e.getString("time");
            month = e.getString("month");
            date = e.getString("date");
            weekday = e.getString("weekday");

            Item item = new Item(title, shortDescription, location, time, month, date, weekday);
            itemList.add(item);

        }

    }*/

    public List<Item> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<Item> readMessagesArray(JsonReader reader) throws IOException {
        List<Item> itemsList = new ArrayList<Item>();

        reader.beginArray();
        while (reader.hasNext()) {
            itemsList.add(readEvent(reader));
        }
        reader.endArray();
        return itemsList;
    }


    public Item readEvent(JsonReader reader) throws IOException {

        reader.beginObject();
        while (reader.hasNext()) {
            String event = reader.nextName();

            switch (event) {
                case "title":
                    title = reader.nextString();
                    break;
                case "shortDescription":
                    shortDescription = reader.nextString();
                    break;
                case "location":
                    location = reader.nextString();
                    break;
                case "time":
                    time = reader.nextString();
                    break;
                case "month":
                    month = reader.nextString();
                    break;
                case "date":
                    date = reader.nextString();
                    break;
                case "weekday":
                    weekday = reader.nextString();
                    break;
            }

        }
        reader.endObject();
        return new Item(title, shortDescription, location, time, month, date, weekday);
    }

    /*public Item readMessage(JsonReader reader) throws IOException {
        long id = -1;
        String text = null;
        User user = null;
        List<Double> geo = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                id = reader.nextLong();
            } else if (name.equals("text")) {
                text = reader.nextString();
            } else if (name.equals("geo") && reader.peek() != JsonToken.NULL) {
                geo = readDoublesArray(reader);
            } else if (name.equals("user")) {
                user = readUser(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Item(title, shortDescription, location, time, month, date, weekday);
    }*/


}
