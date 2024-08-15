package com.adomasda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

enum SomeEnum {
    FIRST_FLOOR,
    SECOND_FLOOR
}

class Configuration {
    private final String status;
    private final SomeEnum floor;
    private final Integer number;

    public Configuration(Integer number ,String status, SomeEnum floor) {
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

class FloorHandler {
    public static void itsUnavailable(Elevator elevator, Floor floor) {
        System.out.println("Floor " + floor.getConfiguration().getFloor() + " is bad ): maybe try next floor.");
    }

    public static void itsAvailable(Elevator elevator, Floor floor) {
        System.out.println("Floor " + floor.getConfiguration().getFloor() + " is bad ): maybe try next floor.");
    }

    public static void unknownStatus(Elevator _unused, Floor floor) {
        System.out.println("Unknown status for floor " + floor.getConfiguration().getFloor());
    }
}

class Floor {
    private final Configuration configuration;
    private final HashMap<String, BiConsumer<Elevator, Floor>> actions = new HashMap<>();

    public Floor(Configuration configuration) {
        this.configuration = configuration;

        actions.put("unavailable",  FloorHandler::itsUnavailable);
        actions.put("available", FloorHandler::itsAvailable);
    }

    public Configuration getConfiguration () {
        return configuration;
    }

    public void request(Elevator elevator) {
        BiConsumer<Elevator, Floor> action = actions.getOrDefault(configuration.getStatus(), FloorHandler::unknownStatus);
        action.accept(elevator, this);
    }
}

class Elevator {
    private final List<Floor> floors;

    public Elevator(Floor... floors) {
        this.floors = Arrays.asList(floors);
    }

    public void gotoFloor(int floorNumber) {
        floors.get(floorNumber - 1).request(this);
        // TODO
    }
}

public class Main {
    public static void main(String[] args) {
        Floor floor1 = new Floor(new Configuration(1, "available", SomeEnum.FIRST_FLOOR));
        Floor floor2 = new Floor(new Configuration(2, "unavailable", SomeEnum.SECOND_FLOOR));

        Elevator elevator = new Elevator(floor1, floor2);

        elevator.gotoFloor(2);
    }
}
