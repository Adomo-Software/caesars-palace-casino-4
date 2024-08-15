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
    /*
    handleRequest_ is per request (look at requestFloor),
    handleReport_ is per floor (look at handleRequestAvailable)
    */

    public static void handleRequestUnavailable(Elevator elevator, Floor floor) {
        System.out.println("Floor " + floor.getConfiguration().getNumber() + " is bad ): maybe try next floor.");
    }

    public static void handleRequestAvailable(Elevator elevator, Floor floor) {
        for (int i = 0; i < floor.getConfiguration().getNumber(); i++) {
            System.out.println(elevator.getFloors().get(i).report());
        }
    }

    public static void handleReportUnavailable(Floor floor) {
        floor.reportString = Integer.toString(floor.getConfiguration().getNumber()) + " - is unavailable";
    }

    public static void handleReportAvailable(Floor floor) {
        floor.reportString = Integer.toString(floor.getConfiguration().getNumber());

    }

    public static void unknownStatus(Elevator _unused, Floor floor) {
        System.out.println("Unknown status for floor " + floor.getConfiguration().getFloor());
    }
}

class Floor {
    private final Configuration configuration;
    private final HashMap<String, BiConsumer<Elevator, Floor>> requestActions = new HashMap<>();
    private final HashMap<String, Consumer<Floor>> reportActions = new HashMap<>();
    public String reportString;

    public Floor(Configuration configuration) {
        this.configuration = configuration;

        requestActions.put("unavailable",  FloorHandler::handleRequestUnavailable);
        requestActions.put("available", FloorHandler::handleRequestAvailable);
        reportActions.put("unavailable",  FloorHandler::handleReportUnavailable);
        reportActions.put("available", FloorHandler::handleReportAvailable);
    }

    public Configuration getConfiguration () {
        return configuration;
    }

    public void request(Elevator elevator) {
        BiConsumer<Elevator, Floor> requestAction = requestActions.getOrDefault(configuration.getStatus(), FloorHandler::unknownStatus);
        requestAction.accept(elevator, this);
    }

    public String report() {
        Consumer<Floor> reportAction = reportActions.get(configuration.getStatus());
        reportAction.accept(this);
        return reportString;
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

    public void requestFloor(int floorNumber) {
        floors.get(floorNumber - 1).request(this);
    }
}

public class Main {
    public static void main(String[] args) {
        Floor floor1 = new Floor(new Configuration(1, "available", SomeEnum.FIRST_FLOOR));
        Floor floor2 = new Floor(new Configuration(2, "available", SomeEnum.SECOND_FLOOR));
        Floor floor3 = new Floor(new Configuration(3, "unavailable", SomeEnum.SECOND_FLOOR));
        Floor floor4 = new Floor(new Configuration(4, "available", SomeEnum.SECOND_FLOOR));

        Elevator elevator = new Elevator(floor1, floor2, floor3, floor4);

        elevator.requestFloor(4);
        elevator.requestFloor(3);
    }
}
