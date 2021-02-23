package com.it.academy.api.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetsUserEntityIdsDto {
    private int userId;
    private List<Integer> petsId;
}
