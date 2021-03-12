package by.grsu.maptwits.api.mappers;

import by.grsu.maptwits.api.objforjson.StateJson;
import by.grsu.maptwits.entity.points.Point;
import by.grsu.maptwits.entity.states.State;
import by.grsu.maptwits.entity.polygons.Polygon;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class StateMapper {
    public State stateMap(StateJson source){
        List<List<List<Double>>> sourcePolygons = source.getPolygons();

        List<Polygon> resultPolygons=new ArrayList<>(sourcePolygons.size());
        for(List<List<Double>> sourcePolygon : sourcePolygons){
            List<Point> poligonPoints=new ArrayList<>(sourcePolygon.size());

            for(List<Double> poligonPoint : sourcePolygon){
                poligonPoints.add(new Point(poligonPoint.get(0),poligonPoint.get(1)));
            }
            resultPolygons.add(new Polygon(poligonPoints));
        }
        return State.builder()
                .name(source.getName())
                .polygons(resultPolygons)
                .build();
    }
    public List<State> statesMap(List<StateJson> source){
        return source.stream().map(StateMapper::stateMap).collect(Collectors.toList());
    }
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
