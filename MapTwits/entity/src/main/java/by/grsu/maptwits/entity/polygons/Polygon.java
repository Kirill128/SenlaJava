package by.grsu.maptwits.entity.polygons;

import by.grsu.maptwits.entity.points.Point;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Polygon {
    private List<Point> points;
}
