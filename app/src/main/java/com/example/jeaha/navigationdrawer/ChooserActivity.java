package com.example.jeaha.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChooserActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final Class[] CLASSES = new Class[]{
            GoogleSignInActivity.class,
            FacebookLoginActivity.class,
            EmailPasswordActivity.class
    };

    private static final String[] CLASS_NAMES = new String[]{
            "Google Sign In",
            "Facebook Sign In",
            "Email & Password Sign In"
    };


    private static final int[] DESCRIPTION_IDS = new int[]{
            R.string.desc_google_sign_in,
            R.string.desc_facebook_login,
            R.string.desc_emailpassword

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set up ListView and Adapter
        ListView listView = findViewById(R.id.list_view);

        MyArrayAdapter adapter = new MyArrayAdapter(this, android.R.layout.simple_list_item_2,
                CLASSES, CLASS_NAMES);
        adapter.setDescriptionIds(DESCRIPTION_IDS);
        adapter.setClassNames(CLASS_NAMES);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class chosen = CLASSES[position];
        startActivity(new Intent(this, chosen));
    }

    public static class MyArrayAdapter extends ArrayAdapter<Class> {

        private Context mContext;
        private Class[] mClasses;
        private int[] mDescriptionIds;
        private String[] mClassNames;

        public MyArrayAdapter(Context context, int resource, Class[] objects, String[] classNames) {
            super(context, resource, objects);

            mContext = context;
            mClasses = objects;
            mClassNames = classNames;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(android.R.layout.simple_list_item_2, null);
            }

            TextView tv1 = view.findViewById(android.R.id.text1);
            tv1.setPadding(0, 3, 0, 3);

            ((TextView) view.findViewById(android.R.id.text1)).setText(mClassNames[position]);
            ((TextView) view.findViewById(android.R.id.text2)).setText(mDescriptionIds[position]);

            return view;
        }

        public void setDescriptionIds(int[] descriptionIds) {
            mDescriptionIds = descriptionIds;
        }

        public void setClassNames(String[] classNames) {
            mClassNames = classNames;
        }

    }
}
