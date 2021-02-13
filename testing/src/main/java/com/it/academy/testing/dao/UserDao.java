package com.it.academy.testing.dao;

import com.it.academy.testing.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,Integer> {

}
