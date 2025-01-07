package org.ulpgc.is1.model;

public class Phone {
    private String number;

    public Phone(String number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("The phone number must have 9 digits");
        }
        this.number = number;
    }

    public boolean isValid(String number) {
        return number != null && number.length() == 9;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
