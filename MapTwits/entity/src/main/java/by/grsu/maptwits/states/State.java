package by.grsu.maptwits.states;

import by.grsu.maptwits.polygons.Polygon;
import by.grsu.maptwits.twits.Twit;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class State {
    private String name;
    private List<Twit> twits;
    private List<Polygon> polygons;
    private String color;
    private double sentiment;
}
