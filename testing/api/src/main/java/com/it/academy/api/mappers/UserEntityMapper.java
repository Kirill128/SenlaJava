package com.it.academy.api.mappers;

import com.it.academy.api.dto.UserEntityDto;
import com.it.academy.entitys.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class UserEntityMapper {
    public UserEntity mapUserEntity(UserEntityDto source){
        return UserEntity.builder().id(source.getId()).name(source.getName()).email(source.getEmail()).build();
    }
    public UserEntityDto mapUserEntityDto(UserEntity source){
        return UserEntityDto.builder().id(source.getId()).name(source.getName()).email(source.getEmail()).build();
    }
    public List<UserEntity> mapUserEntitys(List<UserEntityDto> source){
        return source.stream().map(UserEntityMapper::mapUserEntity).collect(Collectors.toList());
    }
    public List<UserEntityDto> mapUserEntityDtos(List<UserEntity> source){
        return source.stream().map(UserEntityMapper::mapUserEntityDto).collect(Collectors.toList());
    }
}
