package by.grsu.maptwits.api.rest;

import by.grsu.maptwits.entity.states.State;
import by.grsu.maptwits.entity.twits.Twit;

import java.util.List;

public interface IStatesController {
    List<List<Double>> getPolygons(State state);
    void setTwitsToStates(List<Twit> twits,List<State> states);

    void calculateSentiment(List<State> states);
}
