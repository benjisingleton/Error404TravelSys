/**
 * 
 * @author Mostafa Mohamed Ali
 */

class PartyMember{
    private String firstName;
    private String lastName;
    private int age;
    private boolean isAdult;

    public PartyMember(String firstName, String lastName, int age, boolean isAdult) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isAdult = isAdult;
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
    public boolean getAdult() {
        return isAdult;
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
    public void setAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }
}