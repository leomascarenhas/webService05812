package ca.vanier.addresses.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpersTest {

    @Test
    public void testHappyPath() throws Exception {
        String endpoint = Helpers.createAddressesEndpoint("lalala");

        // Just the following line is not enough
        // boolean test = endpoint.equals("lalala/addresses/base");

        assertEquals(endpoint, "lalala/addresses/base");
    }

    @Test
    public void testNullContent() throws Exception {
        // Product owner - Requirement
        // When basePath is null, it should be considered empty string
        String endpoint = Helpers.createAddressesEndpoint(null);
        assertEquals(endpoint, "/addresses/base");
    }

    @Test
    public void testLocalHostCase() throws Exception {
        // Product owner - Requirement
        // If base contains "localhost" thrown an error message: "Do not push your dev tests"

        Exception exception = assertThrows(Exception.class, () -> {
            // Break things here :)
            Helpers.createAddressesEndpoint("http://localhost");
        });

        assertEquals(exception.getMessage(), "Do not push your dev tests");
    }

}