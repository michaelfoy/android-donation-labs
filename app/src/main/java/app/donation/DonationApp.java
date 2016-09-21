package app.donation;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DonationApp extends Application
{
    public final int       target       = 1000;
    public int             totalDonated = 0;
    public List<Donation> donations    = new ArrayList<Donation>();
    public List<User> users    = new ArrayList<User>();

    public boolean newDonation(Donation donation)
    {
        boolean targetAchieved = totalDonated >= target;
        if (!targetAchieved)
        {
            donations.add(donation);
            totalDonated += donation.amount;
        }
        else
        {
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();
        }
        return targetAchieved;
    }

    public void newUser(User user) {
        users.add(user);
    }

    public boolean registeredUser(String email, String password)
    {
        for (User user : users) {
            if(user.email.equals(email) && user.password.equals(password)) {
                Log.v("Login", "Logging in as: " + user.firstName + " " + user.lastName);
                return true;
            }
        }
        return false;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.v("Donate", "Donation App Started");
    }
}