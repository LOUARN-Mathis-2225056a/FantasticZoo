package td1.getOperatingSystem;

public class GetOperatingSystem {
    /**
     * Returns the OS as a string
     *
     * @return The system's os as a string
     */
    public static String getOperatingSystem() {
        String os = System.getProperty("os.name");
        System.out.println("Using System Property: " + os);
        return os;
    }
}
