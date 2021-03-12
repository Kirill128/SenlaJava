package by.grsu.maptwits.statesservice;

import by.grsu.maptwits.api.constants.Paths;
import by.grsu.maptwits.api.fileworker.IStatesReader;
import by.grsu.maptwits.api.fileworker.statesreader.StateReader;
import by.grsu.maptwits.api.mappers.StateMapper;
import by.grsu.maptwits.api.service.IStatesService;
import by.grsu.maptwits.api.service.ITwitService;
import by.grsu.maptwits.entity.states.State;
import by.grsu.maptwits.entity.twits.Twit;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
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

    @Override
    public void setTwitsToStates(List<Twit> twits, List<State> states) {
        for(State state:states){
            state.setTwits(new ArrayList<Twit>());
            List<List<Double>> statePolygons=StateMapper.getPolygons(state);
            for(List<Double> polyPoints:statePolygons) {
                double[] points = new double[polyPoints.size()];
                int i=0;
                for(Double polyPoint: polyPoints)points[i++]=polyPoint;

                Polygon polygon=new Polygon(points);

                for (Twit twit : twits) {
                    double x=twit.getPoint().getY();
                    double y=twit.getPoint().getX();
                    if(polygon.contains(x,y)){
                        state.getTwits().add(twit);
                    }
                }
            }
        }
        states.stream().forEach(System.out::println);
    }

    @Override
    public void calculateSentiment(List<State> states) {
        if(states==null)return;
        for(State s : states){
            double sentiment=0;
            if(s.getTwits()==null)return;
            for(Twit twit:s.getTwits()){
                sentiment+=twit.getSentiment();
            }
            s.setSentiment(sentiment);
        }
    }


//          Getters & Setters


    public IStatesReader getStatesReader() {
        return statesReader;
    }

    public void setStatesReader(IStatesReader statesReader) {
        this.statesReader = statesReader;
    }
}
