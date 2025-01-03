package org.ulpgc.is1.model;

import java.util.Date;

public class Budget {
    public Date date;
    public int amount;

    //TODO: mirar +manager y cómo se relaciona con budget

    public Budget(Date date, int amount) {
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
