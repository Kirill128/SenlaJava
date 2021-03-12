package by.grsu.maptwits.api.rest;

import by.grsu.maptwits.api.mappers.StateMapper;
import by.grsu.maptwits.api.service.IStatesService;
import by.grsu.maptwits.entity.points.Point;
import by.grsu.maptwits.entity.polygons.Polygon;
import by.grsu.maptwits.entity.states.State;
import by.grsu.maptwits.entity.twits.Twit;
import by.grsu.maptwits.statesservice.StatesService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class StatesController implements IStatesController{
    private IStatesService statesService;

    public StatesController(IStatesService statesService) {
        this.statesService = statesService;
    }

    public StatesController(){
        this.statesService=new StatesService();
    }
    @Override
    public List<List<Double>> getPolygons(State state) {//polygons<points of 1 polygon>
        return StateMapper.getPolygons(state);
    }

    @Override
    public void setTwitsToStates(List<Twit> twits, List<State> states) {
        statesService.setTwitsToStates(twits,states);
    }

    @Override
    public void calculateSentiment(List<State> states) {

    }


}
