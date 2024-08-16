package com.adomasda;

import java.util.HashMap;


public class Floor {
    private final Configuration configuration;
    private final HashMap<String, RequestAction> requestActions = new HashMap<>();
    private final HashMap<String, ReportAction> reportActions = new HashMap<>();
    public String reportString;

    public Floor(Configuration configuration) {
        this.configuration = configuration;

        requestActions.put("unavailable", new HandleRequestUnavailable());
        requestActions.put("available", new HandleRequestAvailable());
        reportActions.put("unavailable", new HandleReportUnavailable());
        reportActions.put("available", new HandleReportAvailable());
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void request(Elevator elevator) {
        RequestAction requestAction = requestActions.get(configuration.getStatus());
        requestAction.execute(elevator, this);
    }

    public String report() {
        ReportAction reportAction = reportActions.get(configuration.getStatus());
        reportAction.execute(this);
        return reportString;
    }
}
