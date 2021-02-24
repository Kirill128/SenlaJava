package com.it.academy.api.dao;

import com.it.academy.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDJPADao extends JpaRepository<UserEntity,Integer> {
}
