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
        } else {
            System.out.println("El cliente ya existe y no se añadirá: " + customer.getName() + " " + customer.getSurname());
        }
    }


    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    public void addDevice(Device device) {
        if (device != null && !devices.contains(device)) {
            devices.add(device);
        } else {
            System.out.println("El dispositivo ya existe y no se añadirá: Serial Number " + device.getSerialNumber());
        }
    }


    public List<Device> getDevices() {
        return new ArrayList<>(devices);
    }

    public void addTechnician(Employee technician) {
        if (technician != null && !employees.contains(technician)) {
            employees.add(technician);
        } else {
            System.out.println("El empleado ya existe y no se añadirá: " + technician.getName() + " " + technician.getSurname());
        }
    }


    public List<Employee> getTechnicians() {
        return new ArrayList<>(employees);
    }

    public void service(Device device, ServiceType type, String description, Customer customer, Budget budget) {
        if (device != null && type != null && description != null && !description.isEmpty() && customer != null) {
            device.addService(type, description);
            Service newService = device.getServices().get(device.getServices().size() - 1);

            if (budget != null) {
                newService.setBudget(budget);
            }
        }
    }

    public void payService(Device device, int serviceId, int amount, Date date) {
        if (device == null) {
            throw new IllegalArgumentException("El dispositivo no puede ser nulo.");
        }
        device.payService(serviceId, amount, date);
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