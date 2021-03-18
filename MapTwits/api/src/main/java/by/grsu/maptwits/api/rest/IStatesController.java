package by.grsu.maptwits.api.rest;

import javafx.scene.shape.Polygon;
import by.grsu.maptwits.entity.states.State;
import by.grsu.maptwits.entity.twits.Twit;

import java.util.List;

public interface IStatesController {
    List<List<Double>> getPolygons(State state);
    void setTwitsToStates(List<Twit> twits,List<State> states);

    void calculateSentiment(List<State> states);
    void setTwitsToState(List<Twit> twits, State state, List<Polygon> polygon);
    void setColor(State states);

}
