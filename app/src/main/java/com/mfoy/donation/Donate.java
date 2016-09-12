package com.mfoy.donation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Donate extends AppCompatActivity {
    private Button donateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        donateButton = (Button) findViewById(R.id.donateButton);
        Log.v("Donate", "got the donate button");
        if (donateButton != null)
        {
            Log.v("Donate", "Really got the donate button");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }

    public void donateButtonPressed (View view)
    {
        Log.v("Donate", "Donate Pressed!");
    }
}
