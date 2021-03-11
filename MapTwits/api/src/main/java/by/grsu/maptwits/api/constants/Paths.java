package by.grsu.maptwits.api.constants;

public enum Paths {
    TWITS_PATH("/home/kirill/Programming/SenlaJava/MapTwits/fileworker/src/main/resources/high_school_tweets2014.txt"),
    STATES_PATH("/home/kirill/Programming/SenlaJava/MapTwits/fileworker/src/main/resources/states.json"),
    SENTIMENTS_PATH("/home/kirill/Programming/SenlaJava/MapTwits/fileworker/src/main/resources/sentiments.csv");

    private String value;
    Paths(String value){
        this.value = value;
    }
    public String getValue(){ return value;}
}
