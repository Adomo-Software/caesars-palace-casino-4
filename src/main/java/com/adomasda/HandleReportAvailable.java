package com.adomasda;

class HandleReportAvailable implements ReportAction {
    @Override
    public void execute(Floor floor) {
        FloorHandler.handleReportAvailable(floor);
    }
}
