package eu.it.academy.api.mappers;

import java.util.List;
import java.util.stream.Collectors;
import eu.it.academy.api.dto.PetDto;
import eu.it.academy.entities.Pet;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PetMapper {

    public Pet mapPet(PetDto source) {
        return Pet.builder().id(source.getId()).nickName(source.getNickName()).build();
    }

    public PetDto mapPetDto(Pet source) {
        return PetDto.builder().id(source.getId()).nickName(source.getNickName()).build();
    }

    public List<Pet> mapPets(List<PetDto> source) {
        return source.stream().map(PetMapper::mapPet).collect(Collectors.toList());
    }
    
    public List<PetDto> mapPetDtos(List<Pet> source) {
        return source.stream().map(PetMapper::mapPetDto).collect(Collectors.toList());
    }
}
