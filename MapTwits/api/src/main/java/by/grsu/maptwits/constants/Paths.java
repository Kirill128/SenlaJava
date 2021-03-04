package by.grsu.maptwits.constants;

public enum Paths {
    TWITS_PATH("/home/kirill/Programming/SenlaJava/MapTwits/fileworker/src/main/resources/sentiments.csv"),
    STATES_PATH("/home/kirill/Programming/SenlaJava/MapTwits/fileworker/src/main/resources/sentiments.csv"),
    SENTIMENTS_PATH("/home/kirill/Programming/SenlaJava/MapTwits/fileworker/src/main/resources/sentiments.csv");

    private String value;
    Paths(String value){
        this.value = value;
    }
    public String getValue(){ return value;}
}
