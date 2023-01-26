package ca.vanier.customersapi.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private String email;

    // TODO: Improve it to OneToMany
    @OneToMany(mappedBy="addresses")
    private Set<CustomerAddress> addresses;

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
    public Set<CustomerAddress> getAddresses() {
        return addresses;
    }
    public void setAddresses(Set<CustomerAddress> addresses) {
        this.addresses = addresses;
    }

}
