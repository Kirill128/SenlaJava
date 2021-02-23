package com.it.academy.api.service;

import com.it.academy.api.dto.PetEntityDto;
import com.sun.tools.javac.util.List;

public interface IPetService {
    PetEntityDto getPet(int id);

    PetEntityDto createPet(PetEntityDto pet);

    void updatePet(int id, PetEntityDto pet);

    void deletePet(int id);

    List<PetEntityDto> getAll();
}
