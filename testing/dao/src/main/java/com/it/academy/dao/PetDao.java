package com.it.academy.dao;

import com.it.academy.api.dao.IPetDao;
import com.it.academy.entitys.PetEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PetDao extends AGenericDao<PetEntity> implements IPetDao {

    public PetDao() {
        super(PetEntity.class);
    }
}
