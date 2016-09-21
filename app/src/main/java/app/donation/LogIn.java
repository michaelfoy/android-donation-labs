package app.donation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LogIn extends AppCompatActivity {

    private Button loginButton;
    private EditText email;
    private EditText password;
    private DonationApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.loginButton);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        app = (DonationApp) getApplication();
    }

    public void loginButtonPressed (View view) {
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