package com.adomasda;

public class Configuration {
    private final String status;
    private final SomeEnum floor;
    private Integer number;

    public Configuration(Integer number, String status, SomeEnum floor) {
        this.status = status;
        this.floor = floor;
        this.number = number;
    }

    public Configuration(String status, SomeEnum floor) {
        this.status = status;
        this.floor = floor;
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

    public Configuration setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
