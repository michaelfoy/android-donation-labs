package app.donation.model;

/**
 * @file Donation.java
 * @brief Model for a donation object
 * @version 2016.09.25
 * @author michaelfoy
 */
public class Donation
{
    public int    amount;
    public String method;

    /**
     * Constructor for donation object
     * @param amount Amount donated in €
     * @param method Method os the donation: Direct/ Paypal
     */
    public Donation (int amount, String method)
    {
        this.amount = amount;
        this.method = method;
    }
}
