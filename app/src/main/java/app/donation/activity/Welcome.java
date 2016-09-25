package app.donation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.donation.R;
import app.donation.activity.LogIn;
import app.donation.activity.SignUp;
import app.donation.main.DonationApp;

/**
 * @file Welcome.java
 * @brief Class to provide functionality to activity_welcome.xml layout
 * @version 2016.09.25
 * @author michaelfoy
 */
public class Welcome extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private Button signupButton;
    private DonationApp app;

    /**
     * Activates the layout and instantiates it's widgets
     *
     * @param savedInstanceState Saved data pertaining to the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        loginButton = (Button) findViewById(R.id.LoginButton);
        signupButton = (Button) findViewById(R.id.SignupButton);
        signupButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        app = (DonationApp) getApplication();
    }

    /**
     * Starts the login or signup activity
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.LoginButton:
                startActivity (new Intent(this, LogIn.class));
                break;
            case R.id.SignupButton:
                startActivity (new Intent(this, SignUp.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}

