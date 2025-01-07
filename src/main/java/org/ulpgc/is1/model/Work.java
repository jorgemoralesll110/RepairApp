package org.ulpgc.is1.model;

public class Work {
    public int timeSpent;
    public String description;
    private Employee technician;
    private Service service;

    public Work(Employee technician, Service service, int timeSpent, String description) {
        this.technician = technician;
        this.service = service;
        this.timeSpent = timeSpent;
        this.description = description;
    }

    public Employee getTechnician() {
        return technician;
    }

    public Service getService() {
        return service;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public String getDescription() {
        return description;
    }

    public void setTechnician(Employee technician) {
        this.technician = technician;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
