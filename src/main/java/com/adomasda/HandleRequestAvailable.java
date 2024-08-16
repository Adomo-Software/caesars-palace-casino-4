package com.adomasda;

class HandleRequestAvailable implements RequestAction {
    @Override
    public void execute(Elevator elevator, Floor floor) {
        FloorHandler.handleRequestAvailable(elevator, floor);
    }
}
