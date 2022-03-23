import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class testUserJSON {
    private Scanner scanner;

    public testUserJSON() {
        scanner = new Scanner(System.in);
    }


    public void play() {
        Users users = Users.getInstance();

        System.out.println("***** Current Users *****");
        displayUsers();

        while(addUser()) {
            UUID userID = UUID.randomUUID();
            RegistrationInfo userInfo = getUserInfo();
            ArrayList<PartyMember> partyMembers = new ArrayList<>();
            for (int i = 0; i < 3; i++)
            fillWithPartyMembers(partyMembers);

            users.addRegisteredUser(userID, userInfo, partyMembers);
        }
        System.out.println("***** Your updated list of users *****");
        displayUsers();
        users.logout();

        System.out.println("\nSee ya later!");
    }

    private String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}

    private int getInt(String prompt) {
        System.out.print(prompt + "Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        return age;
    }

    private RegistrationInfo getUserInfo() {
        String firstName = getField("First Name");
		String lastName = getField("Last Name");
        String userName = getField("Username");
        String password = getField("Password");
        int age = getInt("");

        return new RegistrationInfo(firstName, lastName, userName, password, age, false);
    }

    private PartyMember getPartyMember() {
        String firstName = getField("Friend's First Name");
		String lastName = getField("Friend's Last Name");
        int age = getInt("Friend's ");

        return new PartyMember(firstName, lastName, age);
    }

    private void fillWithPartyMembers(ArrayList<PartyMember> partyMembers) {
        PartyMember temp = getPartyMember();
        partyMembers.add(temp);
    }


    private boolean addUser() {
        System.out.print("Would you like to add a new user? (Y or N): ");

        String input = scanner.nextLine();
        
        if(input.toLowerCase().trim().equals("y")) return true;
        return false;
    }

    public void displayUsers() {
        Users users = Users.getInstance();
        ArrayList<RegisteredUser> userList = users.getRegisteredUsers();
        
        for (RegisteredUser user : userList) {
            System.out.println(user.getUserInfo());
        }
    }
    public static void main(String[] args) {
        testUserJSON test = new testUserJSON();
        test.play();
    }
}
