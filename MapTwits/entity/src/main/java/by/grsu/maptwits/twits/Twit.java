package by.grsu.maptwits.twits;

import by.grsu.maptwits.points.Point;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Twit {
    private Point point;
    private String day;
    private String time;
    private List<String> words;
    private double sentiment;

}
