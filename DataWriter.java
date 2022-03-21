	
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Data loader for json files
 * @author rcd1
 * Following Portia's data loader
 */

public class DataWriter extends DataConstants {
	
    /**
     * Write all of our Registered Uses to the JSON file
     */
	public static void saveUsers() {
        Users rUsers = Users.getInstance();
        ArrayList<RegisteredUser> rUserList = rUsers.getRegisteredUsers();
        JSONArray jsonRUsers = new JSONArray();

        //Make the JSON Objects please
        for (int i = 0; i < rUserList.size(); i++) {
            jsonRUsers.add(getUserJSON(rUserList.get(i)));
        }

        //Add those new objects to the JSON File 
        try (FileWriter file = new FileWriter(USERS_FILE_NAME)) {
            file.write(jsonRUsers.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Convert the Registered User into a JSONObject
     * @param rUser the current registered user
     * @return a JSON Object representing the registered user
     */
	public static JSONObject getUserJSON(RegisteredUser rUser) {
        JSONObject rUserDetails = new JSONObject();
        rUserDetails.put(USER_ID, rUser.getUserID().toString());
        rUserDetails.put(USER_INFO, getRInfoJSON(rUser));
        rUserDetails.put(USER_PARTY_MEMBERS,getPMembersJSON(rUser));
        return rUserDetails;
    }
    /**
     * Convert the Registration Info object into a JSON object
     * @param rUser
     * @return a JSON Object of the user's registration info
     */
    public static JSONObject getRInfoJSON(RegisteredUser rUser) {
        JSONObject regInfo = new JSONObject();
        RegistrationInfo userInfo = rUser.getUserInfo();
        regInfo.put(R_INFO_FIRST_NAME, userInfo.getFirstName());
        regInfo.put(R_INFO_LAST_NAME, userInfo.getLastName());
        regInfo.put(R_INFO_USERNAME, userInfo.getUsername());
        regInfo.put(R_INFO_PASSWORD, userInfo.getPassword());
        regInfo.put(R_INFO_AGE, userInfo.getAge());
        regInfo.put(R_INFO_FREQFLYER, userInfo.getFreqFlyer());

        return regInfo;
    }
    /**
     * Convert ArrayList<PartyMember> into a JSON Array
     * @param rUser the user the arraylist derives from
     * @return a JSON Array representation of PartyMembers
     */
    public static JSONArray getPMembersJSON(RegisteredUser rUser) {
        JSONArray partyMem = new JSONArray();
        ArrayList<PartyMember> pMList = rUser.getPartyMembers();
        for (int i = 0; i < pMList.size(); i++) {
            JSONObject tempObj = new JSONObject();
            PartyMember currPMem = pMList.get(i);
            tempObj.put(PM_FIRST_NAME, currPMem.getFirstName());
            tempObj.put(PM_LAST_NAME, currPMem.getLastName());
            tempObj.put(PM_AGE, currPMem.getAge());
            partyMem.add(tempObj);
        }
        return partyMem;
        
        
    }
}
