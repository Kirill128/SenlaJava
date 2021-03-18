package eu.it.academy.api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import eu.it.academy.api.dto.UserDto;
import eu.it.academy.api.dto.UserPetIdsDto;

@Service
public interface IUserService {

    UserDto findUser(int id);
    
    UserDto findUserByFirstName(String firstName);
    
    UserDto createUser(UserDto user);
    
    void updateUser(String firstName, UserDto user, MultipartFile file);
    
    void deleteUser(int id);
    
    List<UserDto> getUsers();

    void assingPetToUser(UserPetIdsDto ids);
}
