package org.ulpgc.is1.model;

public class Employee {
    public final int number;
    public String name;
    public String surname;

    public Employee(int number, String name, String surname) {
        this.number = number;
        this.name = name;
        this.surname = surname;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
