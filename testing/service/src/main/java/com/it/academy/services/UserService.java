package com.it.academy.services;

import com.it.academy.api.dao.IUserDao;
import com.it.academy.api.dto.PetsUserEntityIdsDto;
import com.it.academy.api.dto.UserEntityDto;
import com.it.academy.api.mappers.UserEntityMapper;
import com.it.academy.api.dto.UserPetEntitysIdesDto;
import com.it.academy.api.service.IUserService;
import com.it.academy.entitys.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    private IUserDao userDao;

    public UserService(IUserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public UserEntityDto findUser(int id) {
        UserEntity user= this.userDao.get(id);
        return (user!=null)? UserEntityMapper.mapUserEntityDto(user):null;
    }

    @Override
    public UserEntityDto createUser(UserEntityDto user) {
        return UserEntityMapper.mapUserEntityDto(this.userDao.create(UserEntityMapper.mapUserEntity(user)));
    }

    @Override
    public void updateUser(int id, UserEntityDto user) {
        UserEntity userFromBase=this.userDao.get(id);
        if(userFromBase!=null)
        {
            if(user.getEmail()!=null)userFromBase.setEmail(user.getEmail());
            if(user.getName()!=null)userFromBase.setName(user.getName());
            this.userDao.update(userFromBase);
        }
    }

    @Override
    public void deleteUser(int id) {
        UserEntityDto userDto=this.findUser(id);
        if(userDto!=null)this.userDao.delete(UserEntityMapper.mapUserEntity(userDto));
    }

    @Override
    public List<UserEntityDto> getUsers() {
        return UserEntityMapper.mapUserEntityDtos(this.userDao.getAll());
    }

    @Override
    public void assignPetToUser(UserPetEntitysIdesDto ids) {

    }

    @Override
    public void assignPetsToUser(PetsUserEntityIdsDto ids) {
        
    }


}
