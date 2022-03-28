/**
 * Different airlines
 * @author Benjamin Singleton
 */

public enum Airline {
    DELTA("Delta Airlines"),
    AMERICAN("American Airlines"),
    UNITED("United Airlines"),
    SPIRIT("Spirit Airlines"),
    JETBLUE("Jetblue");

    private final String name;

    private Airline(String name) {
        this.name = name;
    }
    /**
     * Get the Airline Enumeration based on its String
     * @param name the String associated with the Airline
     * @return the Airline of the string
     */
    public static Airline getAL(String name) {
        switch(name) {
            case "Delta Airlines":
            return DELTA;
            case "American Airlines":
            return AMERICAN;
            case "United Airlines":
            return UNITED;
            case "Spirit Airlines":
            return SPIRIT;
            case "Jetblue":
            return JETBLUE;
        }
        return DELTA;
    }
    /**
     * Get the name of the Airline
     * @return a String representation of the Airline enumeration
     */
    public String getName() {
        return name;
    }
}