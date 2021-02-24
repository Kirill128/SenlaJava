package com.it.academy.services;

import com.it.academy.api.dao.IPetDao;
import com.it.academy.api.dto.PetEntityDto;
import com.it.academy.api.mappers.PetEntityMapper;
import com.it.academy.api.service.IPetService;
import com.it.academy.entitys.PetEntity;
import java.util.List;
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
        return PetEntityMapper.mapPetEntityDto(this.petDao.create(PetEntityMapper.mapPetEntity(pet)));
    }

    @Override
    public void updatePet(int id, PetEntityDto pet) {
        PetEntity petFromBase=this.petDao.get(id);
        if(petFromBase!=null)
        {
            if(pet.getName()!=null)petFromBase.setName(pet.getName());
            this.petDao.update(petFromBase);
        }
    }

    @Override
    public void deletePet(int id) {
        PetEntityDto petEntityDto= PetEntityMapper.mapPetEntityDto(this.petDao.get(id));
        if(petEntityDto!=null)this.petDao.delete(PetEntityMapper.mapPetEntity(petEntityDto));
    }

    @Override
    public List<PetEntityDto> getAll() {
        return PetEntityMapper.mapPetDtos(this.petDao.getAll());
    }
}
