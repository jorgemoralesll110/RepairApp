package org.ulpgc.is1.model;

import java.util.List;

public class ServiceManager {
    private List<Customer> customerList;
    private List<Device> deviceList;
    private List<Employee> employeeList;

    public void addCustomer(Customer customer) {
        if (customerList != null) {
            customerList.add(customer);        }
    }

    public void addDevice(Device device) {
        if (deviceList != null) {
            deviceList.add(device);
        }
    }

    public void addTechnician(Employee technician) {
        if (technician != null) {
            employeeList.add(technician);
        }
    }

    public List<Customer> getCustomer() {
        return customerList;
    }

    public List<Device> getDevice() {
        return deviceList;
    }

    public List<Employee> getTechnician() {
        return employeeList;
    }
}
