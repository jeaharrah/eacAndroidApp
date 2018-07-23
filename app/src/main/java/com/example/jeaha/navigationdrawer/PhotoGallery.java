package com.example.jeaha.navigationdrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import java.util.ArrayList;

public class PhotoGallery extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Integer[] image = new Integer[]{
                R.drawable.calendar_item_gradient,
                R.drawable
                        .common_full_open_on_phone,
                R.drawable.ic_link_24dp,
                R.drawable
                        .ic_info_outline_24dp,
                R.drawable.ic_info_black_24dp};

        gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(new PhotoAdapter(this));

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
