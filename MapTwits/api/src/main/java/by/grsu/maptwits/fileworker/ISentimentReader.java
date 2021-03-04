package by.grsu.maptwits.fileworker;

import java.util.Map;

public interface ISentimentReader {
    Map<String,Double> readSentiments(String filePath);
}
