package com.adomasda;

import com.adomasda.Floors.*;

public class Main {
    public static void main(String[] args) {
        Floor floor1 = new FirstFloor(new Configuration("available", SomeEnum.FIRST_FLOOR));
        Floor floor2 = new SecondFloor(new Configuration("available", SomeEnum.SECOND_FLOOR));
        Floor floor3 = new ThirdFloor(new Configuration("unavailable", SomeEnum.SECOND_FLOOR));
        Floor floor4 = new ForthFloor(new Configuration("available", SomeEnum.SECOND_FLOOR));

        Elevator elevator = new Elevator(floor1, floor2, floor3, floor4);

        elevator.requestFloor(4);
        elevator.requestFloor(3);
    }
}
