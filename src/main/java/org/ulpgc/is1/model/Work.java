package org.ulpgc.is1.model;

public class Work {
    public int timeSpent;
    public String description;

    public Work(int timeSpent, String description) {
        this.timeSpent = timeSpent;
        this.description = description;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public String getDescription() {
        return description;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
