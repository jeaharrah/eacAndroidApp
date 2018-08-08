package com.example.jeaha.navigationdrawer;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;


public class NavActivity extends AppCompatActivity {

    protected void replaceContentLayout(int sourceId, int destinationId) {
        View contentLayout = findViewById(destinationId);

        ViewGroup parent = (ViewGroup) contentLayout.getParent();
        int index = parent.indexOfChild(contentLayout);

        parent.removeView(contentLayout);
        contentLayout = getLayoutInflater().inflate(sourceId, parent, false);
        parent.addView(contentLayout, index);
    }

}
