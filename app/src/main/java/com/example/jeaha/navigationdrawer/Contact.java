package com.example.jeaha.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    TextView tv4;
    ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            if (1 < tv4.getLineCount()) {
                tv4.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        tv4.getTextSize() - 2);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
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

        TextView tv1 = (TextView) findViewById(R.id.txtViewContactEmailGreeting);
        TextView tv2 = (TextView) findViewById(R.id.txtViewContactEmail);
        TextView tv3 = (TextView) findViewById(R.id.txtViewVisitUs);
        tv4 = (TextView) findViewById(R.id.txtViewWebpage);

        tv2.setText(Html.fromHtml(getString(R.string.email_link)));
        tv2.setMovementMethod(LinkMovementMethod.getInstance());

        tv4.setText(Html.fromHtml(getString(R.string.website_link)));
        tv4.setMovementMethod(LinkMovementMethod.getInstance());

        ViewTreeObserver vto = tv4.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(onGlobalLayoutListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
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


}
