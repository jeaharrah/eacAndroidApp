package com.example.jeaha.navigationdrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.GridView;

import java.lang.reflect.Field;

public class PhotoGallery extends AppCompatActivity {

    GridView gridView;
    Integer[] imageIDs;
    Field[] fileListInSubfolder;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

/*        fileListInSubfolder = R.raw.class.getFields();

        for (int i = 0; i < fileListInSubfolder.length; i++) {
            Log.i("Raw Asset: ", fileListInSubfolder[i].getName());

            try {
                id = fileListInSubfolder[i].getInt(fileListInSubfolder[i]);
                imageIDs[i] = id;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }*/

        gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(new PhotoAdapter(this, createPhotoIdArray()));

    }

    public Integer[] createPhotoIdArray() {
        //Get a list of the fields in the Raw resources folder and store them
        //in an array of Field objects
        fileListInSubfolder = R.raw.class.getFields();
        imageIDs = new Integer[fileListInSubfolder.length];

        for (int i = 0; i < fileListInSubfolder.length; i++) {
            Log.i("Raw Asset ", fileListInSubfolder[i].getName());

            try {
                id = fileListInSubfolder[i].getInt(fileListInSubfolder[i]);
                imageIDs[i] = id;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return imageIDs;

    }

}