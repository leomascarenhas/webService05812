package ca.vanier.content.util;

public class CustomerMsg {

    public static String getSuccess(String name) {
        return String.format("Customer %s saved", name);
    }

}
