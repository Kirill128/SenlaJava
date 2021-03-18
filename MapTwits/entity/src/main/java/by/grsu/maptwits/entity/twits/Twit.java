package by.grsu.maptwits.entity.twits;

import by.grsu.maptwits.entity.points.Point;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Twit {
    private double sentiment;
    private Point point;
    private String day;
    private String time;
    private String text;

}
