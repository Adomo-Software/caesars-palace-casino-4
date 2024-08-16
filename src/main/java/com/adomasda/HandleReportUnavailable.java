package com.adomasda;

class HandleReportUnavailable implements ReportAction {
    @Override
    public void execute(Floor floor) {
        FloorHandler.handleReportUnavailable(floor);
    }
}
