package org.ulpgc.is1.model;

public class Device {
    public String serialNumber;
    public DeviceType type;

    public Device(String serialNumber, DeviceType type) {
        this.serialNumber = serialNumber;
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public DeviceType getType() {
        return type;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }
}
