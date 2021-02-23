package com.it.academy.api.mappers;

import com.it.academy.api.dto.PetEntityDto;
import com.it.academy.entitys.PetEntity;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PetEntityMapper {
    public PetEntity mapPetEntity(PetEntityDto source){
        return PetEntity.builder().name(source.getName()).id(source.getId()).build();
    }

    public PetEntityDto mapPetEntityDto(PetEntity source){
        return PetEntityDto.builder().id(source.getId()).name(source.getName()).build();
    }

    public List<PetEntity> mapPets(List<PetEntityDto> source){
        return source.stream().map(PetEntityMapper::mapPetEntity).collect(Collectors.toList());
    }
    public List<PetEntityDto> mapPetDtos(List<PetEntity> source){
        return source.stream().map(PetEntityMapper::mapPetEntityDto).collect(Collectors.toList());
    }

}
