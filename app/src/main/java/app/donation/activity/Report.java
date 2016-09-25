package app.donation.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import app.donation.R;
import app.donation.main.DonationApp;
import app.donation.model.Donation;

/**
 * @file Report.java
 * @brief Class to provide functionality to activity_report.xml layout
 * @version 2016.09.25
 * @author michaelfoy
 */
public class Report extends AppCompatActivity
{
    private ListView listView;
    private DonationApp app;

    /**
     * Activates the layout and instantiates it's widgets
     *
     * @param savedInstanceState Saved data pertaining to the activity
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        app = (DonationApp) getApplication();

        listView = (ListView) findViewById(R.id.reportList);
        DonationAdapter adapter = new DonationAdapter (this, app.donations);
        listView.setAdapter(adapter);
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
     * Describes functionality for menu items
     * @param item Menu item which has been selected
     * @return True if operation successful
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuDonate: startActivity (new Intent(this, Donate.class));
                break;
            case R.id.logout: startActivity (new Intent(this, Welcome.class));
                break;
        }
        return true;
    }


    class DonationAdapter extends ArrayAdapter<Donation> {
        private Context context;
        public List<Donation> donations;

        public DonationAdapter(Context context, List<Donation> donations) {
            super(context, R.layout.row_layout, donations);
            this.context = context;
            this.donations = donations;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.row_layout, parent, false);
            Donation donation = donations.get(position);
            TextView amountView = (TextView) view.findViewById(R.id.row_amount);
            TextView methodView = (TextView) view.findViewById(R.id.row_method);

            amountView.setText("" + donation.amount);
            methodView.setText(donation.method);

            return view;
        }

        @Override
        public int getCount() {
            return donations.size();
        }
    }
}