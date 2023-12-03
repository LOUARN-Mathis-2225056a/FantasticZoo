package model.getOperatingSystem;

public class GetOperatingSystem {
    public static String getOperatingSystem() {
        String os = System.getProperty("os.name");
        System.out.println("Using System Property: " + os);
        return os;
    }
}
