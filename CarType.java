/**
 * Different car types
 * @author Benjamin Singleton
 */

public enum CarType {
    ECONOMY("Economy"),
    COMPACT("Compact"),
    SEDAN("Sedan"),
    LUXURY("Luxury"),
    MINIVAN("Minivan"),
    SUV("SUV");

    private final String label;

    private CarType(String label) {
        this.label = label;
    }
    /**
     * Get the CarType based on the label associated with it
     * @param label the label of a CarType
     * @return the CarType associated with the label
     */
    public static CarType getCT(String label) {
        switch (label) {
            case "Economy":
            return ECONOMY;
            case "Compact":
            return COMPACT;
            case "Sedan":
            return SEDAN;
            case "Luxury":
            return LUXURY;
            case "Minivan":
            return MINIVAN;
            case "SUV":
            return SUV;
        }
        return ECONOMY;

    }

    /**
     * Get the label of the CarType
     * @return the String representation of the CarType
     */
    public String getLabel() {
        return label;
    }
}