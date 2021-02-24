package com.it.academy.services;

import com.it.academy.api.dao.IPetDJPADao;
import com.it.academy.api.dao.IPetDao;
import com.it.academy.api.dao.IUserDJPADao;
import com.it.academy.api.dao.IUserDao;
import com.it.academy.api.dto.PetEntityDto;
import com.it.academy.api.dto.UserPetEntitysIdsDto;
import com.it.academy.api.dto.UserEntityDto;
import com.it.academy.api.mappers.UserEntityMapper;
import com.it.academy.api.dto.UserPetEntityIdsDto;
import com.it.academy.api.service.IUserService;
import com.it.academy.entitys.PetEntity;
import com.it.academy.entitys.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserDJPADao userDao;
    @Autowired
    private IPetDJPADao petDao;

//    public UserService(IUserDao userDao){
//        this.userDao=userDao;
//    }

    @Override
    public UserEntityDto findUser(int id) {
        UserEntity user= this.userDao.findById(id).orElse(null);
        return (user!=null)? UserEntityMapper.mapUserEntityDto(user):null;
    }

    @Override
    @Transactional
    public UserEntityDto createUser(UserEntityDto user) {
        return UserEntityMapper.mapUserEntityDto(this.userDao.save(UserEntityMapper.mapUserEntity(user)));
    }

    @Override
    @Transactional
    public void updateUser(int id, UserEntityDto user) {
        UserEntity userFromBase=this.userDao.findById(id).orElse(null);
        if(userFromBase!=null)
        {
            if(user.getEmail()!=null)userFromBase.setEmail(user.getEmail());
            if(user.getName()!=null)userFromBase.setName(user.getName());
            this.userDao.save(userFromBase);
        }
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        this.userDao.deleteById(id);
    }

    @Override
    public List<UserEntityDto> getUsers() {
        return UserEntityMapper.mapUserEntityDtos(this.userDao.findAll());
    }

    @Override
    @Transactional
    public void assignPetToUser(UserPetEntityIdsDto ids) {

    }

    @Override
    @Transactional
    public void assignPetsToUser(UserPetEntitysIdsDto ids) {
        UserEntity user=this.userDao.findById(ids.getUserId()).orElse(null);
        if(user!=null) {
            for (int petId :
                    ids.getPetIds()) {
                PetEntity pet = this.petDao.findById(petId).orElse(null);
                if (pet != null) {
                    user.getPets().add(pet);
                    pet.setUser(user);
                }
            }
            this.userDao.save(user);

        }
    }


}
