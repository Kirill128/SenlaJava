package eu.it.academy.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import eu.it.academy.api.dao.IPetDao;
import eu.it.academy.api.dao.IPetJPADao;
import eu.it.academy.api.dto.PetDto;
import eu.it.academy.api.mappers.PetMapper;
import eu.it.academy.api.services.IPetService;
import eu.it.academy.entities.Pet;

@Service
public class PetService implements IPetService {

    @Autowired
    private IPetJPADao petDao;

    @Override
    public PetDto findPet(int id) {
        Pet pet = this.petDao.findById(id).orElse(null);
        return (pet != null ) ? PetMapper.mapPetDto(pet) : null;
    }

    @Override
    @Transactional
    public PetDto createPet(PetDto pet) {
        Pet entity = PetMapper.mapPet(pet);
        return PetMapper.mapPetDto(this.petDao.save(entity));
    }

    @Override
    @Transactional
    public void updatePet(int id, PetDto petDto) {
        Pet pet = this.petDao.findById(id).orElse(null);
        if(pet != null) {
            this.petDao.save(pet);
        }
    }

    @Override
    @Transactional
    public void deletePet(int id) {
        this.petDao.deleteById(id);
    }

    @Override
    public List<PetDto> getPets() {
        return PetMapper.mapPetDtos(this.petDao.findAll());
    }
}
