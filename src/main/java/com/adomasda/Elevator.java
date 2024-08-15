package com.adomasda;

import java.util.Arrays;
import java.util.List;

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
