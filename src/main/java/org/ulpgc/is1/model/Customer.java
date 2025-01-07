package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String surname;
    private Phone phone;
    private List<Device> owner;

    public Customer(String name, String surname, Phone phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.owner = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public List<Device> getOwners() {
        return owner;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Phone getPhone() {
        return phone;
    }
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) &&
                surname.equals(customer.surname) &&
                phone.getNumber().equals(customer.phone.getNumber());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, surname, phone.getNumber());
    }

}
