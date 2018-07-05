package com.example.jeaha.navigationdrawer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class PhotoAdapter extends BaseAdapter {
    private Context context;

    public Integer[] images = {
            R.drawable.calendar_item_gradient,
            R.drawable.common_full_open_on_phone,
            R.drawable.ic_link_24dp,
            R.drawable.ic_info_outline_24dp,
            R.drawable.ic_info_black_24dp,
            R.drawable.ic_email_24dp,
            R.drawable.ic_menu_gallery,


    };

    public PhotoAdapter(Context c) {
        context = c;

    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(240, 240));
        return imageView;
    }

}
