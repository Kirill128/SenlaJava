package com.it.academy.dao;

import com.it.academy.api.dao.IUserDao;
import com.it.academy.entitys.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AGenericDao<UserEntity> implements IUserDao {
    public UserDao(){
        super(UserEntity.class);
    }
}
