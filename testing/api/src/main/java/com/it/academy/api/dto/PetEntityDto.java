package com.it.academy.api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetEntityDto {

    private int id;
    private String name;
    private UserEntityDto user;
}