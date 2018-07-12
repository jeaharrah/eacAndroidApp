package com.example.jeaha.navigationdrawer;

import android.content.Intent;
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
    Intent intent;

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

        TextView tv5 = (TextView) findViewById(R.id.txtViewStcContactHeader);
        TextView tv6 = (TextView) findViewById(R.id.txtViewStcAbout);
        TextView tv7 = (TextView) findViewById(R.id.txtViewStcContactEmailGreeting);
        TextView tv8 = (TextView) findViewById(R.id.txtViewStcContactEmail);
        TextView tv9 = (TextView) findViewById(R.id.txtViewStcVisitUs);
        TextView tv10 = (TextView) findViewById(R.id.txtViewStcWebpage);

        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Contact.this, About.class);
                startActivity(intent);
            }

        });

        tv8.setText(Html.fromHtml(getString(R.string.stc_email_link)));
        tv8.setMovementMethod(LinkMovementMethod.getInstance());

        tv10.setText(Html.fromHtml(getString(R.string.stc_website_link)));
        tv10.setMovementMethod(LinkMovementMethod.getInstance());


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
