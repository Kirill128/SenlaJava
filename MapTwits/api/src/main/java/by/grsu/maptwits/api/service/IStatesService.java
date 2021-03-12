package by.grsu.maptwits.api.service;


import by.grsu.maptwits.entity.states.State;
import by.grsu.maptwits.entity.twits.Twit;

import java.util.List;

public interface IStatesService {
    List<State> getAllStates();

    void setTwitsToStates(List<Twit> twits, List<State> states);

    void calculateSentiment(List<State> states);
}
