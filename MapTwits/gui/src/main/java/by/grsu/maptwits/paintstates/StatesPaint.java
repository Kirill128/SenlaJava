package by.grsu.maptwits.paintstates;

import by.grsu.maptwits.api.rest.IStatesController;
import by.grsu.maptwits.api.rest.StatesController;
import by.grsu.maptwits.entity.states.State;
import by.grsu.maptwits.statesservice.StatesService;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StatesPaint extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public void configure(){

    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Polygons");

        IStatesController statesController = new StatesController();
        List<State> states = new StatesService().getAllStates();

        List<Polygon> polygonsForGroup = new LinkedList<>();
        for(State state :states){
            List<List<Double>> polygons = statesController.getPolygons(state);
            int polyNum = 0;

            for (List<Double> points : polygons) {
                double[] buf = new double[points.size()];
                int i = 0;
                for (Double point : points) buf[i++] = Math.abs(point) * 10;

                Polygon polygon = new Polygon(buf);
                polygon.setFill(Color.BLACK);
                polygonsForGroup.add(polygon);
            }
        }
//        Arrays.stream(polygonsForGroup).forEach(System.out::println);
        Group group = new Group(polygonsForGroup.toArray(new Polygon[polygonsForGroup.size()]));
        Scene scene=new Scene(group,1920,1080);
        stage.setScene(scene);
        stage.show();
    }
}
