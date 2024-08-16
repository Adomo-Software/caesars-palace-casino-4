package com.adomasda;

class HandleRequestUnavailable implements RequestAction {
    @Override
    public void execute(Elevator elevator, Floor floor) {
        FloorHandler.handleRequestUnavailable(elevator, floor);
    }
}
