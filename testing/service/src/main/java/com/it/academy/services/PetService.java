package com.it.academy.services;

import com.it.academy.api.dao.IPetDao;
import com.it.academy.api.dto.PetEntityDto;
import com.it.academy.api.mappers.PetEntityMapper;
import com.it.academy.api.service.IPetService;
import com.it.academy.entitys.PetEntity;
import com.sun.tools.javac.util.List;
import org.springframework.stereotype.Service;

@Service
public class PetService implements IPetService {

    private IPetDao petDao;

    public PetService(IPetDao petDao){
        this.petDao=petDao;
    }
    @Override
    public PetEntityDto getPet(int id) {
        PetEntityDto petEntityDto= PetEntityMapper.mapPetEntityDto(this.petDao.get(id));
        return petEntityDto;
    }

    @Override
    public PetEntityDto createPet(PetEntityDto pet) {
        return null;
    }

    @Override
    public void updatePet(int id, PetEntityDto pet) {

    }

    @Override
    public void deletePet(int id) {

    }

    @Override
    public List<PetEntityDto> getAll() {
        return null;
    }
}
