package com.it.academy.services;

import com.it.academy.api.dao.IUserDao;
import com.it.academy.api.service.IUserService;
import com.it.academy.entitys.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private IUserDao userDao;

    public UserService(IUserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public UserEntity findUser(int id) {
        return this.userDao.get(id);
    }
}
