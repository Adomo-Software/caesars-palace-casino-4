package com.adomasda;

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
