package com.it.academy.api.service;

import com.it.academy.entitys.UserEntity;

public interface IUserService {
    UserEntity findUser(int id);
}
