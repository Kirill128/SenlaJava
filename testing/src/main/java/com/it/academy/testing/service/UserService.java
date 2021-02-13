package com.it.academy.testing.service;

import com.it.academy.testing.dao.UserDao;
import com.it.academy.testing.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Getter
@Setter
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<UserEntity> getUsers(){
        return this.userDao.findAll();
    }
}
