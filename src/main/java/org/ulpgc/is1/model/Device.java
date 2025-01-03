package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Device {
    public String serialNumber;
    public DeviceType type;
    private Customer customer;
    private List<Service> services;

    public Device(String serialNumber, DeviceType type, Customer customer) {
        this.serialNumber = serialNumber;
        this.type = type;
        this.customer = customer;
        this.services = new ArrayList<>();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public DeviceType getType() {
        return type;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
