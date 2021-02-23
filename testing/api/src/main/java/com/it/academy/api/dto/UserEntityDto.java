package com.it.academy.api.dto;

import com.it.academy.entitys.PetEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntityDto {

    private int id;
    private String name;
    private String email;
    private List<PetEntityDto> pets;
}
