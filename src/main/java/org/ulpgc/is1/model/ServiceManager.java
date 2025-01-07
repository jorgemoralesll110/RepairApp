package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceManager {
    private List<Customer> customers;
    private List<Device> devices;
    private List<Employee> employees;

    public ServiceManager() {
        this.customers = new ArrayList<>();
        this.devices = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        if (customer != null && !customers.contains(customer)) {
            customers.add(customer);
        }
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    public void addDevice(Device device) {
        if (device != null && !devices.contains(device)) {
            devices.add(device);
        }
    }

    public List<Device> getDevices() {
        return new ArrayList<>(devices);
    }

    public void addTechnician(Employee technician) {
        if (technician != null && !employees.contains(technician)) {
            employees.add(technician);
        }
    }

    public List<Employee> getTechnicians() {
        return new ArrayList<>(employees);
    }

    public void service(Device device, ServiceType type, String description) {
        if (device != null && type != null && description != null && !description.isEmpty()) {
            device.addService(type, description);
        }
    }

    public void payService(Device device, int serviceId, int amount, Date date) {
        if (device != null && serviceId > 0 && amount > 0 && date != null) {
            device.payService(serviceId, amount, date);
        }
    }

    public List<Device> getDeviceServiceList(ServiceType type) {
        List<Device> matchingDevices = new ArrayList<>();
        for (Device device : devices) {
            List<Service> services = device.getServices();
            if (services != null) {
                for (Service service : services) {
                    if (service.getType() == type) {
                        matchingDevices.add(device);
                        break;
                    }
                }
            }
        }
        return matchingDevices;

    }

}