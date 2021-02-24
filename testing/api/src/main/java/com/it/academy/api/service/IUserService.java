package com.it.academy.api.service;

import com.it.academy.api.dto.UserPetEntitysIdsDto;
import com.it.academy.api.dto.UserEntityDto;
import com.it.academy.api.dto.UserPetEntityIdsDto;
import java.util.List;

public interface IUserService {
    UserEntityDto findUser(int id);

    UserEntityDto createUser(UserEntityDto user);

    void updateUser(int id,UserEntityDto user);

    void deleteUser(int id);

    List<UserEntityDto> getUsers();

    void assignPetToUser(UserPetEntityIdsDto ids);

    void assignPetsToUser(UserPetEntitysIdsDto ids);
}
