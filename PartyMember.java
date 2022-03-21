/**
 * Class to manage Party Member
 * @author Mostafa Mohamed Ali
 */

class PartyMember{
    private String firstName;
    private String lastName;
    private Long age;

    /**
     * Sets local variables to passed in parameters
     * @param firstName passenger first name
     * @param lastName passenger last name
     * @param age passenger age
     */
    public PartyMember(String firstName, String lastName, Long age) {
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
    public Long getAge() {
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
    public void setAge(Long age) {
        this.age = age;
    }
    //Other Methods
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName +
        "\nAge: " + age;
    }
}