package by.grsu.maptwits.api.fileworker;

import by.grsu.maptwits.entity.twits.Twit;

import java.util.List;

public interface ITwitReader {
    List<Twit> readTwits(String filePath);
}
