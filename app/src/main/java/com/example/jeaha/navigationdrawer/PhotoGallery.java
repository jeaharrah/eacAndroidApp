package com.example.jeaha.navigationdrawer;

import android.os.Bundle;
import android.provider.Contacts;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class PhotoGallery extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);
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

        recyclerView = (RecyclerView) findViewById(R.id.galleryView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),
                3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<PhotoCell> photoCellArrayList = prepareData();
        GalleryAdapter galleryAdapter = new GalleryAdapter(getApplicationContext(), photoCellArrayList);
        recyclerView.setAdapter(galleryAdapter);

    }

    private ArrayList<PhotoCell> prepareData() {
        ArrayList<PhotoCell> singlePhoto = new ArrayList<>();
        for (int i = 0; i < image_titles.length; i++) {
            PhotoCell photoCell = new PhotoCell();
            photoCell.setImage(image_ids[i]);
            photoCell.setTitle(image_titles[i]);
            singlePhoto.add(photoCell);
        }

        return singlePhoto;
    }

    private final String image_titles[] = {
            "Image 1",
            "Image 2",
            "Image 3",
            "Image 4",
            "Image 5",
            "Image 6",
    };

    private final Integer image_ids[] = {
            R.drawable.ic_email_24dp,
            R.drawable.ic_email_24dp,
            R.drawable.ic_email_24dp,
            R.drawable.ic_email_24dp,
            R.drawable.ic_email_24dp,
            R.drawable.ic_email_24dp

    };

}
