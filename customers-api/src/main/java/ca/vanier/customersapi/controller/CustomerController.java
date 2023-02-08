package ca.vanier.customersapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.vanier.addresses.utils.Constants;
import ca.vanier.addresses.utils.Helpers;
import ca.vanier.customersapi.entity.Customer;
import ca.vanier.customersapi.service.CustomerService;
import ca.vanier.utils.NameItHelper;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PostMapping("/update/{id}")
    public String updateById(@RequestBody Customer customer, @PathVariable Long id) {
        if (!customerService.findById(id).isPresent()) {
            return "Customer not found";
        };

        customerService.updateById(customer, id);
        return "Success";
    }

    @GetMapping("/list")
    public List<Customer> listTestLeo() {
        return customerService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (!customerService.findById(id).isPresent()) {
            return "Customer not found";
        };

        customerService.deleteById(id);
        return "Success";
    }

    @GetMapping(Constants.ADDR_PATH)
    public String isItAddressesKey() {
        return Helpers.createAddressesEndpoint(Constants.ADDR_PATH);
    }

    @GetMapping("/testnl")
    public String testNewLib() {
        return NameItHelper.baseMyPath("leo/test/hahaha");
    }

}
