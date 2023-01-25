package ca.vanier.customersapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private String email;

    // TODO: Improve it to OneToMany
    @OneToOne(cascade = CascadeType.ALL)
    // Please, connect this two columns and give me...
    @JoinColumn(name="address_id", referencedColumnName = "id")
    // This object :)
    private CustomerAddress address;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public CustomerAddress getAddress() {
        return address;
    }
    public void setAddress(CustomerAddress address) {
        this.address = address;
    }

}
