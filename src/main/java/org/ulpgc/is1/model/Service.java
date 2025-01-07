package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Service {
    private static int NEXT_ID = 0;
    public final int id;
    public ServiceType type;
    public String description;
    private Payment payment = null;
    private Budget budget;
    private List<Employee> technicians;
    private List<Work> works;

    public Service(ServiceType type, String description) {
        this.id = NEXT_ID++;
        this.type = type;
        this.description = description;
        this.technicians = new ArrayList<>();
        this.works = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ServiceType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public List<Work> getWorks() {
        return new ArrayList<>(works);
    }

    public void addWork(Work work) {
        if (work != null) {
            this.works.add(work);
        }
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public List<Employee> getTechnicians() {
        return technicians;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addTechnician(Employee technician) {
        this.technicians.add(technician);
    }

    public void pay(Payment payment) {
        if (this.payment != null) {
            throw new IllegalStateException("This service has already been paid.");
        }
        this.payment = payment;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }
}
