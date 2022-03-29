/**
 * Class to manage Party Member
 * @author Mostafa Mohamed Ali
 */

class PartyMember{
    private String firstName;
    private String lastName;
    private int age;

    /**
     * Sets local variables to passed in parameters
     * @param firstName passenger first name
     * @param lastName passenger last name
     * @param age passenger age
     */
    public PartyMember(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    //Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public boolean isAdult() {
        return age >= 18;
    }
    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * Returns Party Member details
     * @return firstname, lastname, and age
     */
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName +
        "\nAge: " + age;
    }
}