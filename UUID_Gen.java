import java.util.UUID;
/**
 * @author rcd1
 * Generates a UUID 
 */
public class UUID_Gen {
    /**
     * Generates a UUID
     * @param args an array of sequence characters
     */
        public static void main(String[] args) {
        UUID newID = UUID.randomUUID();
        System.out.println("Your ID: " + newID);   
    }
}
