package app.donation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.TextView;

import app.donation.R;
import app.donation.main.DonationApp;
import app.donation.model.Donation;

/**
 * @file Donate.java
 * @brief Class to provide functionality to activity_donate.xml layout
 * @version 2016.09.25
 * @author michaelfoy
 */
public class Donate extends AppCompatActivity implements View.OnClickListener {

    private Button donateButton;
    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;
    private EditText numberText;
    private int totalDonated;
    private TextView amountLabel;
    private DonationApp app;

    /**
     * Activates the layout and instantiates it's widgets
     *
     * @param savedInstanceState Saved data pertaining to the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        donateButton = (Button) findViewById(R.id.donateButton);
        paymentMethod = (RadioGroup) findViewById(R.id.paymentMethod);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        amountPicker = (NumberPicker) findViewById(R.id.amountPicker);
        numberText = (EditText) findViewById(R.id.numberText);
        amountLabel = (TextView) findViewById(R.id.AmountLabel);
        app = (DonationApp) getApplication();

        amountPicker.setMaxValue(1000);
        amountPicker.setMinValue(0);
        progressBar.setMax(1000);
        amountLabel.setText("" + totalDonated);
        donateButton.setOnClickListener(this);

        if (donateButton != null) {
            Log.v("DonationApp", "Donate button loaded");
        }
    }

    /**
     * Creates the menu
     *
     * @param menu Menu object
     * @return True if menu successfully created
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }

    /**
     * Creates and saves a new donation, updates widget data
     */
    public void onClick (View view) {
        String method = paymentMethod.getCheckedRadioButtonId() == R.id.PayPal ? "PayPal" : "Direct";
        int donatedAmount = amountPicker.getValue();
        if (donatedAmount == 0) {
            String text = numberText.getText().toString();
            if (!text.equals("")) {
                donatedAmount = Integer.parseInt(text);
            }
        }
        if (donatedAmount > 0) {
            app.newDonation(new Donation(donatedAmount, method));
            progressBar.setProgress(app.totalDonated);
            String totalDonatedStr = "$" + app.totalDonated;
            amountLabel.setText(totalDonatedStr);
        }

        amountPicker.setValue(0);
        numberText.setText("0");
        Log.v("DonationApp", "Donation complete");
    }

    /**
     * Describes functionality for menu items
     * @param item Menu item which has been selected
     * @return True if operation successful
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuReport: startActivity (new Intent(this, Report.class));
                break;
            case R.id.logout: startActivity (new Intent(this, Welcome.class));
                break;
        }
        return true;
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

