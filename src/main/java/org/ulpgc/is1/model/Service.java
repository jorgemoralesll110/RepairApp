package org.ulpgc.is1.model;

public class Service {
    private static int NEXT_ID = 0;
    public final int id;
    public ServiceType type;
    public String description;

    public Service(ServiceType type, String description) {
        this.id = NEXT_ID++;
        this.type = type;
        this.description = description;
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

    public void setType(ServiceType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
