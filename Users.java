import java.util.ArrayList;

/**
 * A class to hold all of the Registered Users
 * @author rcd1
 */

public class Users {
    private static Users rUsers = null;
    private static ArrayList<RegisteredUser> rUserList = new ArrayList<>();
    
    /**
     * Create a new Users()
     */
    private Users() {
       rUserList = DataLoader.loadUsers();
    }
    /**
     * Set your Users to THE Users object
     * @return the only Users object
     */
    public static Users getInstance() {
        if (rUsers == null) {
            rUsers = new Users();
        }
        return rUsers;
    }
    /**
     * Get ArrayList of Registered Users
     * @return The giant list of all our users
     */
    public ArrayList<RegisteredUser> getRegisteredUsers(){
        return rUserList;
    }
    /**
     * Add a new RegisteredUser to the LIST
     * @param userID user's ID
     * @param userInfo user's info
     * @param partyMembers user's bestest friends and family (maybe)
     */
    public void addRegisteredUser(String userID, RegistrationInfo userInfo, ArrayList<PartyMember> partyMembers) {
        rUserList.add(new RegisteredUser(userID, userInfo, partyMembers));
    }
    /**
     * We're done here, save the Users where you do
     */
    public void logout() {
        DataWriter.saveUsers();
    }
}
