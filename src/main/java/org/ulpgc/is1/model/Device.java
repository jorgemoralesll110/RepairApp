package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Device {
    public String serialNumber;
    public DeviceType type;
    private Customer owner;
    private List<Service> services;

    public Device(String serialNumber, DeviceType type, Customer owner) {
        this.serialNumber = serialNumber;
        this.type = type;
        this.owner = owner;
        this.services = new ArrayList<>();

//        if (owner != null) {
//            owner.addDevice(this);
//        }
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public DeviceType getType() {
        return type;
    }
    public Customer getOwner() {
        return owner;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public void setType(DeviceType type) {
        this.type = type;
    }
    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
