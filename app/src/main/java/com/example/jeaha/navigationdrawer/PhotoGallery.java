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

    /**
     * Measure used memory and give garbage collector time to free up some space.
     *
     * @param callback Callback operations to be done when memory is free.
     */
    public static void waitForGarbageCollector(final Runnable callback) {

        Runtime runtime;
        long maxMemory;
        long usedMemory;
        double availableMemoryPercentage = 1.0;
        final double MIN_AVAILABLE_MEMORY_PERCENTAGE = 0.1;
        final int DELAY_TIME = 5 * 1000;

        runtime =
                Runtime.getRuntime();

        maxMemory =
                runtime.maxMemory();

        usedMemory =
                runtime.totalMemory() -
                        runtime.freeMemory();

        availableMemoryPercentage =
                1 -
                        (double) usedMemory /
                                maxMemory;

        if (availableMemoryPercentage < MIN_AVAILABLE_MEMORY_PERCENTAGE) {

            try {
                Thread.sleep(DELAY_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            waitForGarbageCollector(
                    callback);
        } else {

            // Memory resources are availavle, go to next operation:

            callback.run();
        }
    }

}