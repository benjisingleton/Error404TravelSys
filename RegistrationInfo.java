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
    private Long age;
    private boolean freqFlyer;

    public RegistrationInfo() {
        firstName = "";
        lastName = "";
        username = "";
        password = "";
        age = (long) 0;
        freqFlyer = false;
    }
    public RegistrationInfo(String firstName, String lastName, String username, String password, Long age, boolean freqFlyer) {
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
    public Long getAge() {
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
    public void setAge(Long age) {
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
}
