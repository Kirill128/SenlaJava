package by.grsu.maptwits.statesreader;

import by.grsu.maptwits.fileworker.IStatesReader;
import by.grsu.maptwits.states.State;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class StateReader implements IStatesReader {
    @Override
    public List<State> readStates(String filePath) {
        List<State> states =new LinkedList<>();

        try(BufferedReader file=new BufferedReader(new FileReader(filePath))){
            String line;
            while((line=file.readLine())!=null){

            }
        }catch (IOException e){
            System.out.printf(e.getMessage());
        }

        return states;
    }
}
