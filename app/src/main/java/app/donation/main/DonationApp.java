package app.donation.main;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.donation.model.Donation;
import app.donation.model.User;

/**
 * @file DonationApp.java
 * @brief Class to provide back-end application functionality
 * @version 2016.09.25
 * @author michaelfoy
 */
public class DonationApp extends Application
{
    public final int       target       = 1000;
    public int             totalDonated = 0;
    public List<Donation> donations    = new ArrayList<Donation>();
    public List<User> users    = new ArrayList<User>();

    /**
     * If target not yet reached, saves a new donation
     * @param donation The new donation
     * @return True if the target has already been reached
     */
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

    /**
     * Saves a new user
     * @param user The new user
     */
    public void newUser(User user) {
        users.add(user);
    }

    /**
     * Checks login data against registered users
     * @param email Input email
     * @param password Input password
     * @return True if the data matches a registered user
     */
    public boolean registeredUser(String email, String password)
    {
        for (User user : users) {
            if(user.email.equals(email) && user.password.equals(password)) {
                Log.v("DonationApp", "Logging in as: " + user.firstName + " " + user.lastName);
                return true;
            }
        }
        return false;
    }

    /**
     * Activates the layout and instantiates it's widgets
     */
    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.v("Donate", "Donation App Started");
    }
}