package by.grsu.maptwits.statesreader;

import by.grsu.maptwits.fileworker.IStatesReader;
import by.grsu.maptwits.objforjson.StateJson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StateReader implements IStatesReader {

    @Override
    public List<StateJson> readStates(String filePath)  {
        List<StateJson> statesJson = new LinkedList<>();
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            JsonNode root=objectMapper.readTree(new FileReader(filePath));
            for (Iterator<Map.Entry<String, JsonNode>> it = root.fields(); it.hasNext(); ) {
                Map.Entry<String, JsonNode> entry = it.next();

                List<List<List<Double>>> polygons=new LinkedList<>();
                JsonNode polygonsArrNode = entry.getValue();
                for (Iterator<JsonNode> iter = polygonsArrNode.elements(); iter.hasNext(); ) {
                    JsonNode pointsArrNode = iter.next();//.get(0);

                    List<List<Double>> points=new LinkedList<>();
                    for(Iterator<JsonNode> pointsIt = pointsArrNode.elements(); pointsIt.hasNext();){
                        JsonNode pointNode=pointsIt.next();

                        List<Double>point=new ArrayList<>();
                        for(Iterator<JsonNode> poinIt=pointNode.elements();poinIt.hasNext();) {
                            JsonNode coorNode=poinIt.next();
                            point.add(coorNode.asDouble());
                        }
                        points.add(point);
                    }
                    polygons.add(points);
                }
                statesJson.add(new StateJson(entry.getKey(),polygons));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return statesJson;
    }
}
