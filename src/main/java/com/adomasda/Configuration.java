package com.adomasda;

class Configuration {
    private final String status;
    private final SomeEnum floor;
    private final Integer number;

    public Configuration(Integer number, String status, SomeEnum floor) {
        this.status = status;
        this.floor = floor;
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public SomeEnum getFloor() {
        return floor;
    }

    public Integer getNumber() {
        return number;
    }
}
