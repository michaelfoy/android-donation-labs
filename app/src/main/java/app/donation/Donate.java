package app.donation;

import android.net.Uri;
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
import android.widget.Toast;


public class Donate extends AppCompatActivity {
    private Button donateButton;
    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;
    private EditText numberText;
    private int totalDonated = 0;
    private TextView amountLabel;

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

        amountPicker.setMaxValue(1000);
        amountPicker.setMinValue(0);
        progressBar.setMax(1000);
        amountLabel.setText("" + totalDonated);

        if (donateButton != null) {
            Log.v("Donate", "Really got the donate button");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }

    public void donateButtonPressed(View view) {
        if (totalDonated >= 1000) {
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();
        } else if (amountPicker.getValue() != 0) {
            totalDonated += amountPicker.getValue();
        } else {
            String text = numberText.getText().toString();
            if (text != "") {
                totalDonated += Integer.parseInt(text);
            }
        }
        progressBar.setProgress(totalDonated);
        amountLabel.setText("" + totalDonated);
        String method = paymentMethod.getCheckedRadioButtonId() == R.id.PayPal ? "PayPal" : "Direct";
        Log.v("Donate", "Total donated increased to " + totalDonated + " by: " + method);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuReport:
                Toast.makeText(this, "Report Selected", Toast.LENGTH_SHORT).show();
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

