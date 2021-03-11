package by.grsu.maptwits.statesservice;

import by.grsu.maptwits.api.constants.Paths;
import by.grsu.maptwits.api.fileworker.IStatesReader;
import by.grsu.maptwits.api.fileworker.statesreader.StateReader;
import by.grsu.maptwits.api.mappers.StateMapper;
import by.grsu.maptwits.api.objforjson.StateJson;
import by.grsu.maptwits.api.service.IStatesService;
import by.grsu.maptwits.api.service.ITwitService;
import by.grsu.maptwits.entity.states.State;

import java.util.List;

public class StatesService implements IStatesService {

    private ITwitService twitService;
    private IStatesReader statesReader;

    public StatesService(ITwitService twitService,IStatesReader statesReader) {
        this.statesReader = statesReader;
        this.twitService=twitService;
    }
    public StatesService(){
        this.statesReader=new StateReader();
        this.twitService=new TwitService();
    }

    @Override
    public List<State> getAllStates() {
        List<State> states= StateMapper.statesMap(statesReader.readStates(Paths.STATES_PATH.getValue()));
//        if (states!=null)states.stream().forEach(System.out::println);
        return states;
    }



//          Getters & Setters


    public IStatesReader getStatesReader() {
        return statesReader;
    }

    public void setStatesReader(IStatesReader statesReader) {
        this.statesReader = statesReader;
    }
}
