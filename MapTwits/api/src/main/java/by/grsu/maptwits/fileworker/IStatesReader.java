package by.grsu.maptwits.fileworker;


import by.grsu.maptwits.objforjson.StateJson;

import java.util.List;

public interface IStatesReader {
    List<StateJson> readStates(String filePath) ;

}
