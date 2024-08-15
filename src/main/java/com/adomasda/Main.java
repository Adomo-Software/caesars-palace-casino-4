package com.adomasda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

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
    public static void requestHandleUnavailable(Elevator elevator, Floor floor) {
        System.out.println("Floor " + floor.getConfiguration().getFloor() + " is bad ): maybe try next floor.");
    }

    public static void requestHandleAvailable(Elevator elevator, Floor floor) {
        for (int i = 0; i < floor.getConfiguration().getNumber(); i++) {
            System.out.println(elevator.getFloors().get(i).getConfiguration().getNumber());
        }
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

        actions.put("unavailable",  FloorHandler::requestHandleUnavailable);
        actions.put("available", FloorHandler::requestHandleAvailable);
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

    public List<Floor> getFloors() {
        return floors;
    }

    public void gotoFloor(int floorNumber) {
        floors.get(floorNumber - 1).request(this);
        // TODO
    }
}

public class Main {
    public static void main(String[] args) {
        Floor floor1 = new Floor(new Configuration(1, "available", SomeEnum.FIRST_FLOOR));
        Floor floor2 = new Floor(new Configuration(2, "available", SomeEnum.SECOND_FLOOR));
        Floor floor3 = new Floor(new Configuration(3, "unavailable", SomeEnum.SECOND_FLOOR));
        Floor floor4 = new Floor(new Configuration(4, "available", SomeEnum.SECOND_FLOOR));

        Elevator elevator = new Elevator(floor1, floor2, floor3, floor4);

        elevator.gotoFloor(4);
    }
}
