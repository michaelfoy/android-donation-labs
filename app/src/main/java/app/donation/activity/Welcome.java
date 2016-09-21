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


public class Welcome extends AppCompatActivity {

    private Button loginButton;
    private Button signupButton;
    private DonationApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        loginButton = (Button) findViewById(R.id.LoginButton);
        signupButton = (Button) findViewById(R.id.SignupButton);
        app = (DonationApp) getApplication();
    }

    public void loginButtonPressed (View view) {
        startActivity (new Intent(this, LogIn.class));
    }

    public void signupButtonPressed (View view) {
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

