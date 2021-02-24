package com.it.academy.api.dto;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPetEntityIdsDto {
    private int userId;
    private int petId;
}

