package by.grsu.maptwits.fileworker;

import by.grsu.maptwits.states.State;

import java.util.List;

public interface IStatesReader {
    List<State> readStates(String filePath);

}
