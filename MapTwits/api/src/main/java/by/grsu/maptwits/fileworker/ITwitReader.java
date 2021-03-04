package by.grsu.maptwits.fileworker;

import by.grsu.maptwits.twits.Twit;

import java.util.List;

public interface ITwitReader {
    List<Twit> readTwits(String filePath);
}
