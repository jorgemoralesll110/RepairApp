package org.ulpgc.is1.model;

public class Phone {
    private String number;

    public boolean isValid() {
        return number != null && number.length() == 9;
    }

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
