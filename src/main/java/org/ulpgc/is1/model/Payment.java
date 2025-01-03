package org.ulpgc.is1.model;

import java.util.Date;

public class Payment {
    public Date date;
    public int amount;

    public Payment(Date date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
