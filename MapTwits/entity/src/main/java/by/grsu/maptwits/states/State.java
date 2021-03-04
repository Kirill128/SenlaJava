package by.grsu.maptwits.states;

import by.grsu.maptwits.lines.Line;
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
    private List<Twit> twits;
    private List<Line> lines;
    private String color;
    private double sentiment;

}
