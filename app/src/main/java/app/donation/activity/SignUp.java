package app.donation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.donation.R;
import app.donation.activity.Donate;
import app.donation.main.DonationApp;
import app.donation.model.User;

/**
 * @file SignUp.java
 * @brief Class to provide functionality to activity_signup.xml layout
 * @version 2016.09.25
 * @author michaelfoy
 */
public class SignUp extends AppCompatActivity {

    private Button registerButton;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private DonationApp app;

    /**
     * Activates the layout and instantiates it's widgets
     *
     * @param savedInstanceState Saved data pertaining to the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        registerButton = (Button) findViewById(R.id.registerButton);
        app = (DonationApp) getApplication();
    }

    /**
     * Registers a new user with input data, guides the user to login activity
     */
    public void registerButtonPressed () {

        String firstNameStr = firstName.getText().toString();
        String lastNameStr = lastName.getText().toString();
        String emailStr = email.getText().toString();
        String passwordStr = password.getText().toString();

        User newUser = new User(firstNameStr, lastNameStr, emailStr, passwordStr);
        app.newUser(newUser);
        Log.v("DonationApp", "New User: " + firstNameStr + " " + lastNameStr);
        startActivity (new Intent(this, LogIn.class));
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