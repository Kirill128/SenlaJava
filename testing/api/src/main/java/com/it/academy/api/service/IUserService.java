package com.it.academy.api.service;

import com.it.academy.api.dto.PetsUserEntityIdsDto;
import com.it.academy.api.dto.UserEntityDto;
import com.it.academy.api.dto.UserPetEntitysIdesDto;
import java.util.List;

public interface IUserService {
    UserEntityDto findUser(int id);

    UserEntityDto createUser(UserEntityDto user);

    void updateUser(int id,UserEntityDto user);

    void deleteUser(int id);

    List<UserEntityDto> getUsers();

    void assignPetToUser(UserPetEntitysIdesDto ids);

    void assignPetsToUser(PetsUserEntityIdsDto ids);
}
