package com.it.academy.api.dao;

import com.it.academy.entitys.PetEntity;
import com.it.academy.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetDJPADao extends JpaRepository<PetEntity,Integer> {
}
