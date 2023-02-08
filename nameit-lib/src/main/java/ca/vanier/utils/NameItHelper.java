package ca.vanier.utils;

import ca.vanier.addresses.entity.Address;

public class NameItHelper {
    
    public static String baseMyPath(String path) {

        Address address = new Address();
        address.setCity("Laval");

        return "http://localhost/" + path;
    }

}
