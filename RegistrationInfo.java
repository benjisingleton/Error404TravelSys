/**
 * A List of registration info for
 * Registered Users
 * @author rcd1
 */
public class RegistrationInfo {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int age;
    private boolean freqFlyer;

    /**
     * Sets local variables to passed in parameters
     * @param user's firstname
     * @param user's lastname
     * @param user's username
     * @param user's password
     * @param user's age
     * @param to set if the user is a frequent flyer
     */
    public RegistrationInfo(String firstName, String lastName, String username, String password,  int age, boolean freqFlyer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.age = age;
        this.freqFlyer = freqFlyer;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    protected String getUsername() {
        return username;
    }
    protected String getPassword() {
        return password;
    }
    public int getAge() {
        return age;
    }
    public boolean getFreqFlyer() {
    return freqFlyer;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setFreqFlyer(boolean freqFlyer) {
        this.freqFlyer = freqFlyer;
    }
    
    // Other Methods
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName +
        "\nUsername: " + username + "\nPassword: " + password + 
        "\nAge: " + age + "\nFrequent Flyer: " + freqFlyer;
    }

    /**
     * compares the log in details with the saved details
     * @return username and password
     */
    public boolean tryLogin(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }
}
