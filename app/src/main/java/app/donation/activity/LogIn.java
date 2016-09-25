package app.donation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.donation.R;
import app.donation.activity.Donate;
import app.donation.main.DonationApp;

/**
 * @file Login.java
 * @brief Class to provide functionality to activity_login.xml layout
 * @version 2016.09.25
 * @author michaelfoy
 */
public class LogIn extends AppCompatActivity implements View.OnClickListener{

    private Button loginButton;
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
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        app = (DonationApp) getApplication();
    }

    /**
     * If user data is correct, logs in the user.
     */
    @Override
    public void onClick (View view) {
        String emailStr = email.getText().toString();
        String passwordStr = password.getText().toString();

        if (app.registeredUser(emailStr, passwordStr)) {
            startActivity(new Intent(this, Donate.class));
        } else {
            Toast toast = Toast.makeText(this, "Log in failed :(", Toast.LENGTH_SHORT);
            toast.show();
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