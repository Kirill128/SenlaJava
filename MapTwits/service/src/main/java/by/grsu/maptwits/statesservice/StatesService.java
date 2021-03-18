package by.grsu.maptwits.statesservice;

import by.grsu.maptwits.api.constants.Paths;
import by.grsu.maptwits.api.fileworker.IStatesReader;
import by.grsu.maptwits.api.fileworker.statesreader.StateReader;
import by.grsu.maptwits.api.mappers.StateMapper;
import by.grsu.maptwits.api.service.IStatesService;
import by.grsu.maptwits.api.service.ITwitService;
import by.grsu.maptwits.entity.states.State;
import by.grsu.maptwits.entity.twits.Twit;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

public class StatesService implements IStatesService {

    public static String [] SENTIMENT_COLORS=new String[]{"#22366A", "#3B596A", "#427676", "#3F9A82", "#77BFFF",
                                                            "#FFFFFF","#ECDB60", "#FFDD22", "#FFAA11", "#FF8800", "#FF5500"};
    public static final String GRAY = "#AAAAAA";

    private IStatesReader statesReader;

    public StatesService(IStatesReader statesReader) {
        this.statesReader = statesReader;
    }
    public StatesService(){
        this.statesReader=new StateReader();
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
        calculateSentiment(states);
    }

    @Override
    public void setTwitsToState(List<Twit> twits, State state, List<Polygon> polygons) {
        if(state.getTwits()==null)state.setTwits(new ArrayList<Twit>());
        for(Polygon polygon: polygons){
            for(Twit twit:twits){
                if(polygon.contains(new Point2D(twit.getPoint().getX(),twit.getPoint().getY()))){
                    state.getTwits().add(twit);
                }
            }
        }
        calculateSentiment(state);
    }

    @Override
    public void setColor(State state) {
            int sentiment_scale=1;
            if(state.getTwits().isEmpty()){
                state.setColor(GRAY);
                return;
            }
            double scaled = (sentiment_scale * state.getSentiment() + 1)/2;
            int index  = (int)(scaled * SENTIMENT_COLORS.length);

            if (index < 0)
                index = 0;
            if (index >= SENTIMENT_COLORS.length)
                index = SENTIMENT_COLORS.length - 1;
            state.setColor( SENTIMENT_COLORS[index]);
    }

    @Override
    public void calculateSentiment(List<State> states) {
        if(states==null)return;
        for(State s : states){
            calculateSentiment(s);
        }
    }
    public void calculateSentiment(State state){
        double sentiment=0;
        if(state.getTwits()==null)return;
        for(Twit twit:state.getTwits()){
            sentiment+=twit.getSentiment();
        }
        state.setSentiment(sentiment);
    }




//          Getters & Setters


    public IStatesReader getStatesReader() {
        return statesReader;
    }

    public void setStatesReader(IStatesReader statesReader) {
        this.statesReader = statesReader;
    }
}
