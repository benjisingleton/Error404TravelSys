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

    public static CarType getCT(String label) {
        switch (label) {
            case "Economy":
            return CarType.ECONOMY;
            case "Compact":
            return CarType.COMPACT;
            case "Sedan":
            return CarType.SEDAN;
            case "Luxury":
            return CarType.LUXURY;
            case "Minivan":
            return CarType.MINIVAN;
            case "SUV":
            return CarType.SUV;
        }
        return CarType.ECONOMY;

    }

    public String getLabel() {
        return label;
    }
}