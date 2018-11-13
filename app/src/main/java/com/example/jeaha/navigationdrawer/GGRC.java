package com.example.jeaha.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class GGRC extends AppCompatActivity {

    LinearLayout greenActionsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ggrc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView userTxtView = findViewById(R.id.ggrc_user_txtView);

        /*final ToggleButton toggleButton = findViewById(R.id.toggleButton);
        final LinearLayout greenActionsLayout = findViewById(R.id.greenActionsList);

        final boolean checkedState = toggleButton.isChecked();

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkedState) {
                    greenActionsLayout.setVisibility(View.VISIBLE);
                } else {
                    greenActionsLayout.setVisibility(View.GONE);
                }
            }
        });*/

        /*try {
            fbName = fbInstance.user.getDisplayName();
        } catch (NullPointerException e) {
            Log.e("GGRC", "Facebook User NullPointerException: ", e);
        }

        if (fbName == null) {
            try {
                googleEmail = googleInstance.user.getEmail();
            } catch (NullPointerException e) {
                Log.e("GGRC", "Google User NullPointerException: ", e);
            }
        }
        try {
            email = emailInstance.user.getEmail();
        } catch (NullPointerException e) {
            Log.e("GGRC", "Email User NullPointerException: ", e);
        }


        if (fbName == null & googleEmail == null & email == null) {
            userTxtView.setText("Please sign in to track your GoGreen Rewards Card credits!");
        } else {
            if (fbName != null) {
                name = fbName;
            } else if (googleEmail != null) {
                name = googleEmail;
            } else {
                name = email;
            }
        }*/
        String message = "";
        String authName = "";

        /*try {
            authName = googleInstance.mAuth
                    .getCurrentUser().getDisplayName();
        } catch (NullPointerException e) {
            Log.e("GGRC", "NullPointerException", e);
        }

        if (authName == null) {
            message = "Please log in.";
        } else {
            message = getString(R.string.ggrc_user_greeting_fmt, authName);
        }

        userTxtView.setText(message);*/

    }

    public void onToggleClicked(View view) {
        greenActionsLayout = findViewById(R.id.greenActionsList);

        if (((ToggleButton) view).isChecked()) {
            greenActionsLayout.setVisibility(View.VISIBLE);
        } else {
            greenActionsLayout.setVisibility(View.GONE);
        }

    }
}
