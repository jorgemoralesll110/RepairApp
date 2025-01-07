package org.ulpgc.is1.model;

import java.util.Date;

public class Budget {
    public Date date;
    public int amount;
    private Employee manager;

    public Budget(Date date, int amount, Employee manager) {
        this.date = date;
        this.amount = amount;
        this.manager = manager;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public Employee getManager() {
        return manager;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
