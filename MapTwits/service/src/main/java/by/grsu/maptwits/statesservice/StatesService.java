package by.grsu.maptwits.statesservice;

import by.grsu.maptwits.fileworker.IStatesReader;
import by.grsu.maptwits.service.IStatesService;
import by.grsu.maptwits.service.ITwitService;
import by.grsu.maptwits.states.State;

import java.util.List;

public class StatesService implements IStatesService {

    private ITwitService twitService;
    private IStatesReader statesReader;

    public StatesService(ITwitService twitService,IStatesReader statesReader) {
        this.statesReader = statesReader;
        this.twitService=twitService;
    }

    @Override
    public List<State> getAllStates() {

        return null;
    }



//          Getters & Setters


    public IStatesReader getStatesReader() {
        return statesReader;
    }

    public void setStatesReader(IStatesReader statesReader) {
        this.statesReader = statesReader;
    }
}
