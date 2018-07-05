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

        final Integer[] image = new Integer[]{R.drawable.calendar_item_gradient, R.drawable
                .common_full_open_on_phone, R.drawable.ic_link_24dp, R.drawable
                .ic_info_outline_24dp, R.drawable.ic_info_black_24dp};

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

    /*public class GridAdapter extends ArrayAdapter {
        private Integer[] Image;
        private int resource;
        private LayoutInflater inflater;

        public GridAdapter(Context context, int resource, Integer[] image) {
            super(context, resource, image);
            Image = image;
            this.resource = resource;
            inflater = (LayoutInflater)PhotoGallery.this.getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder Holder = null;

            if (convertView == null) {
                Holder = new ViewHolder();
                convertView = inflater.inflate(resource, null);
                Holder.IMAGE = (ImageView) convertView.findViewById(R.id.imageID);
                convertView.setTag(Holder);

            } else {
                Holder = (ViewHolder) convertView.getTag();
            }

            Holder.IMAGE.setImageResource(Image[position]);
            Holder.IMAGE.setScaleType(ImageView.ScaleType.CENTER_CROP);

            return convertView;

        }

        class ViewHolder {
            private ImageView IMAGE;
        }



    }*/


}
