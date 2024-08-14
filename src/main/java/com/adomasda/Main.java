package com.adomasda;

import java.util.HashMap;

enum SomeEnum {
    FIRST_FLOOR,
    SECOND_FLOOR
}

class Configuration {
    private final String status;
    private final SomeEnum floor;

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
}

class Floor {
    private final Configuration configuration;
    private final HashMap<String, Runnable> actions = new HashMap<>();

    public Floor(Configuration configuration) {
        this.configuration = configuration;

        actions.put("available", this::itsAvailable);
        actions.put("unavailable", this::itsUnavailable);

        actions.getOrDefault(configuration.getStatus(), this::unknownStatus).run();
    }

    public void itsAvailable() {
        System.out.println("Floor " + configuration.getFloor() + " is working, lets get the party rolling 🕺🕺🕺!!");
    }

    public void itsUnavailable() {
        System.out.println("Floor " + configuration.getFloor() + " is bad ): maybe try next floor.");
    }

    private void unknownStatus() {
        System.out.println("Unknown status for floor " + configuration.getFloor());
    }
}

public class Main {
    public static void main(String[] args) {
        Floor floor1 = new Floor(new Configuration("available", SomeEnum.FIRST_FLOOR));
        Floor floor2 = new Floor(new Configuration("unavailable", SomeEnum.SECOND_FLOOR));
    }
}
