package app.donation;

/**
 * @file User.java
 * @brief A class to describe a user object and relevant methods
 * @author michaelfoy
 * @version 2016.09.21
 **/

public class User {

    String firstName;
    String lastName;
    String email;
    String password;

    /**
     * Creates a new User
     * @param firstName User's first name
     * @param lastName User's last name
     * @param email User's email address
     * @param password User's password
     */
    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}
