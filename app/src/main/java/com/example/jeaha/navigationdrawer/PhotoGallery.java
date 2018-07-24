package com.example.jeaha.navigationdrawer;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PhotoGallery extends AppCompatActivity {

    GridView gridView;
    String[] fileListInSubfolder;
    Integer[] imageIDs;
    int id;
    final AssetManager assetManager = getAssets();
    final String photoPath = "eac_photos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            // for assets/subFolderInAssets add only subfolder name
            fileListInSubfolder = assetManager.list(photoPath);

            if (fileListInSubfolder == null) {
                // dir does not exist or is not a directory
            } else {
                for (int i = 0; i < fileListInSubfolder.length; i++) {
                    // Get filename of file or directory
                    String filename = fileListInSubfolder[i];

                    for (int j = 0; j < imageIDs.length; j++) {
                        id = getResources().getIdentifier(filename, "assets/eac_photos",
                                getPackageName());
                        id = imageIDs[j];
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(new PhotoAdapter(this, imageIDs));

    }


}
