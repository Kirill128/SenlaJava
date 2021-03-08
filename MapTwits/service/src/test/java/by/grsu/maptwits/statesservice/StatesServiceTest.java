package by.grsu.maptwits.statesservice;

import by.grsu.maptwits.constants.Paths;
import by.grsu.maptwits.sentimentreader.SentimentReader;
import by.grsu.maptwits.statesreader.StateReader;
import by.grsu.maptwits.twitreader.TwitReader;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatesServiceTest {

    @Test
    public void getAllStates() {
        StatesService service=new StatesService(new TwitService(new SentimentReader().readSentiments(Paths.SENTIMENTS_PATH.getValue())
                ,new TwitReader()),new StateReader());
        service.getAllStates();
    }
}