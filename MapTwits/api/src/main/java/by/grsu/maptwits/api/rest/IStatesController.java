package by.grsu.maptwits.api.rest;

import by.grsu.maptwits.entity.states.State;

import java.util.List;

public interface IStatesController {
    List<List<Double>> getPolygons(State state);
}
