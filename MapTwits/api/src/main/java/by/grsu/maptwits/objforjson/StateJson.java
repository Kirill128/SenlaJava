package by.grsu.maptwits.objforjson;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StateJson {
    String name;
    List<List<List<Double>>> polygons;
}
