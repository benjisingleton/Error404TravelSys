/**
 * 
 * @author Mostafa Mohamed Ali
 */
import java.util.ArrayList;

class PartyMember implements RegisteredUser{

    private String firstName() {
        return firstname;
    }

    private String lastName() {
        return lastName;
    }

    private int age() {
        return age;
    }

    private boolean isAdult() {
        if(age >= 18) {
            return isAdult;
        }
    }

    public PartyMember(String firstName, String lastName, int age, boolean isAdult) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isAdult = isAdult;
    }
}