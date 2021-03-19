package by.grsu.maptwits.paintstates;

import by.grsu.maptwits.api.rest.IStatesController;
import by.grsu.maptwits.api.rest.StatesController;
import by.grsu.maptwits.api.service.ITwitService;
import by.grsu.maptwits.entity.states.State;
import by.grsu.maptwits.entity.twits.Twit;
import by.grsu.maptwits.statesservice.StatesService;
import by.grsu.maptwits.statesservice.TwitService;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class StatesPaint extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Polygons");

        IStatesController statesController = new StatesController();
        ITwitService twitService=new TwitService();
        List<State> states = new StatesService().getAllStates();

        List<Twit> twits=twitService.getAllTwitsWithSentiment();
        statesController.setTwitsToStates(twits,states);
        List<Polygon> polygonsForGroup = new LinkedList<>();

        for(State state :states){
            List<List<Double>> polygons = statesController.getPolygons(state);
            int polyNum = 0;

            for (List<Double> points : polygons) {
                double[] buf = new double[points.size()];
                int i = 0;
                for (Double point : points) {
                    if(i%2==0)buf[i++] = (180-Math.abs(point))*10+400;
                    else buf[i++] = (90-point)*10;
                }
                Polygon polygon = new Polygon(buf);

                polygon.setStroke(Color.BLACK);
                polygonsForGroup.add(polygon);
                statesController.setColor(state);
                polygon.setFill(Color.web(state.getColor()));
            }
        }
        states.stream().forEach(new Consumer<State>() {
            @Override
            public void accept(State state) {
                System.out.println(state.getName()+" :"+state.getSentiment()+", color: "+ state.getColor());
                state.getTwits().stream().forEach((a)-> System.out.println(a.getSentiment()));
            }
        });

        Group group = new Group(polygonsForGroup.toArray(new Polygon[polygonsForGroup.size()]));

        Scene scene=new Scene(group,1920,1080);
        scene.setFill(Color.web("#fadada"));
//------------------------Bar Chart---------------------
        List<Integer> allCountOfSameSentiments=new ArrayList<>(11);
        for(int i=0;i<11;i++)allCountOfSameSentiments.add(0);
        for(State s : states){
            allCountOfSameSentiments.set(s.getColorIndex(), allCountOfSameSentiments.get(s.getColorIndex())+1);
        }

        CategoryAxis x=new CategoryAxis();
        x.setLabel("Sentiment Ranges");
        NumberAxis y=new NumberAxis();
        y.setLabel("States Count");

        BarChart barChart=new BarChart(x,y);

        XYChart.Series series=new XYChart.Series();
        List<XYChart.Data> datas=new ArrayList<>();
        for(int i=-50;i<=50;i+=10){

            int index=i/10+5;
            XYChart.Data data=new XYChart.Data(String.valueOf(i),allCountOfSameSentiments.get(index));
            series.getData().add(data);

            datas.add(data);
        }
        barChart.getData().add(series);



        Group group1=new Group(barChart);
        Scene scene1=new Scene(group1,1920,1080);

        int index=0;
        for(XYChart.Data d: datas){
            d.getNode().setStyle("-fx-background-color:"+StatesService.SENTIMENT_COLORS[index++]+";");
        }
//--------------------------------------------------------
        stage.setScene(scene1);
        stage.show();
    }

}
