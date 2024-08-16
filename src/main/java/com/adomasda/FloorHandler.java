package com.adomasda;

class FloorHandler {
    /*
    FloorHandler is for containing all handle_ logic in one file.

    handleRequest_ is per request (look at Elevator.requestFloor),
    handleReport_ is per floor (look at FloorHandler.handleRequestAvailable)
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
