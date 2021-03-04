package by.grsu.maptwits.sentimentreader;

import by.grsu.maptwits.fileworker.ISentimentReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SentimentReader implements ISentimentReader {

    @Override
    public Map<String, Double> readSentiments(String filePath) {
        Map<String,Double> sentiments=new HashMap<>();

        try(BufferedReader file=new BufferedReader(new FileReader(filePath))){
            String line;
            String[] wordAndValue;
            while((line=file.readLine())!=null){
                wordAndValue=line.split(",");
                sentiments.put(wordAndValue[0],Double.parseDouble(wordAndValue[1]));
            }
        }catch (IOException | NumberFormatException e){
            System.out.printf(e.getStackTrace()+e.getMessage());
        }

        return sentiments;
    }
}
