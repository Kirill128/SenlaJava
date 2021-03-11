package by.grsu.maptwits.api.fileworker;


import by.grsu.maptwits.api.objforjson.StateJson;

import java.util.List;

public interface IStatesReader {
    List<StateJson> readStates(String filePath) ;

}
