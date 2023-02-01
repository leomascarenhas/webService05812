package ca.vanier.customersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

// @EntityScan(basePackageClasses = {ca.vanier.customersapi.entity.Customer.class, ca.vanier.addresses.entity.Address.class})
@EntityScan(basePackages = {"ca.vanier.customersapi.entity", "ca.vanier.addresses.entity"})
@SpringBootApplication
public class CustomersApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersApiApplication.class, args);
    }

}
