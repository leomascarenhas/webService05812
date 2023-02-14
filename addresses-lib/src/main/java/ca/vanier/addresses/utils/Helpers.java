package ca.vanier.addresses.utils;

public class Helpers {
    
    public static String createAddressesEndpoint(String basePath) throws Exception {
        // Test if basePath is null, consider as an empty string
        if (basePath == null) {
            basePath = "";
        }
        if (basePath.startsWith("http://localhost")) {
            throw new Exception("Do not push your dev tests");
        }

        return basePath + Constants.ADDR_PATH + "/base";
    }

}
