package by.grsu.maptwits.statesservice;

import by.grsu.maptwits.fileworker.ISentimentReader;
import by.grsu.maptwits.fileworker.ITwitReader;
import by.grsu.maptwits.service.ITwitService;
import by.grsu.maptwits.twits.Twit;

import java.util.List;
import java.util.Map;

public class TwitService implements ITwitService {

    private ISentimentReader sentimentReader;
    private ITwitReader twitReader;

    public TwitService(ISentimentReader sentimentReader, ITwitReader twitReader) {
        this.sentimentReader = sentimentReader;
        this.twitReader = twitReader;
    }

    @Override
    public List<Twit> getAllTwits() {
//        Map<String,Double> map=sentimentReader.readSentiments("/home/kirill/Programming/SenlaJava/MapTwits/fileworker/src/main/resources/sentiments.csv");
//        for(Map.Entry<String,Double> entry : map.entrySet()) System.out.println(entry);
        twitReader.readTwits("/home/kirill/Programming/SenlaJava/MapTwits/fileworker/src/main/resources/high_school_tweets2014.txt").stream().forEach(System.out::println);
        return null;
    }

    //               Getters & Setters

    public ISentimentReader getSentimentReader() {
        return sentimentReader;
    }

    public void setSentimentReader(ISentimentReader sentimentReader) {
        this.sentimentReader = sentimentReader;
    }

    public ITwitReader getTwitReader() {
        return twitReader;
    }

    public void setTwitReader(ITwitReader twitReader) {
        this.twitReader = twitReader;
    }
}
