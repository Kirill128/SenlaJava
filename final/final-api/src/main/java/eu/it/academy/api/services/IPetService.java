package eu.it.academy.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import eu.it.academy.api.dto.PetDto;
import eu.it.academy.api.dto.UserDto;

@Service
public interface IPetService {

    PetDto findPet(int id);
    
    PetDto createPet(PetDto user);
    
    void updatePet(int id, PetDto user);
    
    void deletePet(int id);
    
    List<PetDto> getPets();
}
