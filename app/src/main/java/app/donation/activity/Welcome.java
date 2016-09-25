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
public class Welcome extends AppCompatActivity {

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
        app = (DonationApp) getApplication();
    }

    /**
     * Starts the login activity
     */
    public void loginButtonPressed () {
        startActivity (new Intent(this, LogIn.class));
    }

    /**
     * Starts the signup activity
     */
    public void signupButtonPressed () {
        startActivity (new Intent(this, SignUp.class));
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

