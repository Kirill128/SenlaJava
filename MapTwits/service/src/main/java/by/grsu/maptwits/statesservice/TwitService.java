package by.grsu.maptwits.statesservice;

import by.grsu.maptwits.constants.Paths;
import by.grsu.maptwits.fileworker.ISentimentReader;
import by.grsu.maptwits.fileworker.ITwitReader;
import by.grsu.maptwits.service.ITwitService;
import by.grsu.maptwits.twits.Twit;

import java.util.List;
import java.util.Map;

public class TwitService implements ITwitService {

    private Map<String,Double> sentimentMap;
    private ITwitReader twitReader;

    public TwitService(Map<String,Double> sentimentMap, ITwitReader twitReader) {
        this.sentimentMap = sentimentMap;
        this.twitReader = twitReader;
    }

    @Override
    public List<Twit> getAllTwitsWithSentiment() {
        List<Twit> twits=twitReader.readTwits(Paths.TWITS_PATH.getValue());
        double sentiment;
        for(Twit t:twits){
            sentiment=0;
            for(String s:t.getWords()){
                sentiment+=this.sentimentMap.getOrDefault(s,0.0);
            }
            t.setSentiment(sentiment);
        }

        return twits;
    }

    //               Getters & Setters


    public ITwitReader getTwitReader() {
        return twitReader;
    }

    public void setTwitReader(ITwitReader twitReader) {
        this.twitReader = twitReader;
    }
}
