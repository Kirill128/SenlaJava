package by.grsu.maptwits.api.rest;

import by.grsu.maptwits.api.service.IStatesService;
import by.grsu.maptwits.entity.points.Point;
import by.grsu.maptwits.entity.polygons.Polygon;
import by.grsu.maptwits.entity.states.State;
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
        List<Polygon> polygons=state.getPolygons();

        List<List<Double>> resPolygons=new ArrayList<>(polygons.size());
        for(Polygon polygon : polygons){
            int pointsCount=polygon.getPoints().size()*2;

            List<Double> resPolygonPoints=new ArrayList<>(pointsCount);
            for(Point p: polygon.getPoints()){
                resPolygonPoints.add(p.getX());
                resPolygonPoints.add(p.getY());
            }
            resPolygons.add(resPolygonPoints);
        }

        return resPolygons;
    }


}
