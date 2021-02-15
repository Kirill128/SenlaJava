package com.it.academy.services;

import com.it.academy.api.dao.IPetDao;
import com.it.academy.api.service.IPetService;
import com.it.academy.entitys.PetEntity;
import org.springframework.stereotype.Service;

@Service
public class PetService implements IPetService {

    private IPetDao petDao;

    public PetService(IPetDao petDao){
        this.petDao=petDao;
    }
    @Override
    public PetEntity getPet(int id) {
        return this.petDao.get(id);
    }
}
