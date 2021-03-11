package by.grsu.maptwits.api.service;

import by.grsu.maptwits.entity.twits.Twit;

import java.util.List;

public interface ITwitService {
    List<Twit> getAllTwitsWithSentiment();
}
