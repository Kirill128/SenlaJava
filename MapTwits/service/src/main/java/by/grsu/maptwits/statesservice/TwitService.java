package by.grsu.maptwits.statesservice;

import by.grsu.maptwits.api.constants.Paths;
import by.grsu.maptwits.api.fileworker.ISentimentReader;
import by.grsu.maptwits.api.fileworker.ITwitReader;
import by.grsu.maptwits.api.fileworker.sentimentreader.SentimentReader;
import by.grsu.maptwits.api.fileworker.twitreader.TwitReader;
import by.grsu.maptwits.api.service.ITwitService;
import by.grsu.maptwits.entity.twits.Twit;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwitService implements ITwitService {

    private Map<String,Double> sentimentMap;
    private ITwitReader twitReader;

    public TwitService(Map<String,Double> sentimentMap, ITwitReader twitReader) {
        this.sentimentMap = sentimentMap;
        this.twitReader = twitReader;
    }
    public TwitService(){
        this.sentimentMap = new SentimentReader().readSentiments(Paths.SENTIMENTS_PATH.getValue());
        this.twitReader = new TwitReader();
    }

    @Override
    public List<Twit> getAllTwitsWithSentiment() {
        List<Twit> twits=twitReader.readTwits(Paths.TWITS_PATH.getValue());
        double sentiment;
        Set<Map.Entry<String,Double>> entries=sentimentMap.entrySet();
        for(Twit t:twits){
            sentiment=0;

            for(Map.Entry<String,Double> entry:entries) {
                Pattern pattern =Pattern.compile(entry.getKey(),Pattern.CASE_INSENSITIVE);
                Matcher matcher=pattern.matcher(t.getText());
                while(matcher.find()){
                    sentiment+= entry.getValue();
                    matcher.replaceAll( "");
                }
            }

            t.setSentiment(sentiment);
        }
        twits.stream().forEach(System.out::println);

        return twits;
    }

    //               Getters & Setters


    public Map<String, Double> getSentimentMap() {
        return sentimentMap;
    }

    public void setSentimentMap(Map<String, Double> sentimentMap) {
        this.sentimentMap = sentimentMap;
    }
    public ITwitReader getTwitReader() {
        return twitReader;
    }

    public void setTwitReader(ITwitReader twitReader) {
        this.twitReader = twitReader;
    }
}
