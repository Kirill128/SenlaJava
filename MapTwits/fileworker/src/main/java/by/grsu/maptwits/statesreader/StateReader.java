package by.grsu.maptwits.statesreader;

import by.grsu.maptwits.fileworker.IStatesReader;
import by.grsu.maptwits.objforjson.StateJson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class StateReader implements IStatesReader {

    @Override
    public List<StateJson> readStates(String filePath)  {
        List<StateJson> statesJson = null;
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            JsonNode root=objectMapper.readTree(new FileReader(filePath));


        } catch (IOException e) {
            e.printStackTrace();
        }

        return statesJson;
    }
}
