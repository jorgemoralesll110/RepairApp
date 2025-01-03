package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
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

    public void addService(ServiceType type, String description) {
        Service service = new Service(type, description);
        services.add(service);
    }

    public void payService(int serviceId, int amount, Date date) {
        for (Service service : services) {
            if (service.getId() == serviceId) {
                service.pay(new Payment(date, amount));
                return;
            }
        }
        throw new IllegalArgumentException("Service not found.");
    }

    public Service[] getServices() {
        return services.toArray(new Service[0]);
    }
}
