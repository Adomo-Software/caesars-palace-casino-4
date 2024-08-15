package com.adomasda;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

class Floor {
    private final Configuration configuration;
    private final HashMap<String, BiConsumer<Elevator, Floor>> requestActions = new HashMap<>();
    private final HashMap<String, Consumer<Floor>> reportActions = new HashMap<>();
    public String reportString;

    public Floor(Configuration configuration) {
        this.configuration = configuration;

        requestActions.put("unavailable", FloorHandler::handleRequestUnavailable);
        requestActions.put("available", FloorHandler::handleRequestAvailable);
        reportActions.put("unavailable", FloorHandler::handleReportUnavailable);
        reportActions.put("available", FloorHandler::handleReportAvailable);
    }

    public Configuration getConfiguration() {
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
