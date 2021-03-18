package eu.it.academy.services.services;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import eu.it.academy.api.dao.IPetJPADao;
import eu.it.academy.api.dao.IUserJPADao;
import eu.it.academy.api.dto.UserDto;
import eu.it.academy.api.dto.UserPetIdsDto;
import eu.it.academy.api.mappers.UserMapper;
import eu.it.academy.api.services.IUserService;
import eu.it.academy.entities.Pet;
import eu.it.academy.entities.Role;
import eu.it.academy.entities.User;
import eu.it.academy.services.utils.LogoFileUploader;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private IUserJPADao userJPADao;

    @Autowired
    private IPetJPADao petJPADao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto findUser(int id) {
        User user = this.userJPADao.findById(id).orElse(null);
        return (user != null) ? UserMapper.mapUserDto(user) : null;
    }
    
    @Override
    public UserDto findUserByFirstName(String username) {
        return UserMapper.mapUserDto(this.userJPADao.findByUsername(username));
    }
        
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.getRoles().add(new Role("ROLE_USER"));
        User savedUser = this.userJPADao.save(user);
        return UserMapper.mapUserDto(savedUser);
    }

    @Override
    public void updateUser(String firstName, UserDto userDto, MultipartFile file) {
//        User user = this.userJPADao.findById(id).orElse(null);
        User user = this.userJPADao.findByUsername(firstName);
        if(user != null) {
            user.setUserName(userDto.getUsername());
            user.setSalary(userDto.getSalary());
            this.userJPADao.save(user);
        }
        try {
            LogoFileUploader.updateOrCreateLogo(file, userDto);
        } catch (IOException e) {
            log.error("Failed to upload image. Error message: {}", e.getMessage());
        }
    }

    @Override
    public void deleteUser(int id) {
        this.userJPADao.deleteById(id);
    }

    @Override
    public List<UserDto> getUsers() {
        return UserMapper.mapUserDtos(userJPADao.findAll());
    }

    @Override
    public void assingPetToUser(UserPetIdsDto ids) {
        User user = this.userJPADao.findById(ids.getUserId()).orElse(null);
        Pet pet = this.petJPADao.findById(ids.getPetId()).orElse(null);
        pet.setUser(user);
        this.petJPADao.save(pet);
        log.info("Pet assigned to user {}!", user.getUserName());
    }

    
    
    
    
    
    
    
//    @Autowired
//    private IUserDao userDao;
//
//    @Override
//    public UserDto findUser(int id) {
//        User user = this.userDao.get(id);
//        return UserMapper.mapUserDto(user);
//    }
//
//    @Override
//    @Transactional
//    public UserDto createUser(UserDto user) {
//        User entity = UserMapper.mapUser(user);
//        entity.setPets(new ArrayList<>());
//        User savedUser = this.userDao.create(entity);
//        return UserMapper.mapUserDto(savedUser);
//    }
//
//    @Override
//    @Transactional
//    public void updateUser(int id, UserDto user) {
//        User entity = this.userDao.get(id);
//        entity.setFirstName(Optional.ofNullable(user.getFirstName()).orElse("DefaultName"));
//        entity.setSalary(user.getSalary());
//        this.userDao.update(entity);
//    }
//
//    @Override
//    @Transactional
//    public void deleteUser(int id) {
//        User entity = this.userDao.get(id);
//        this.userDao.delete(entity);
//    }
//
//    @Override
//    public List<UserDto> getUsers() {
//        return UserMapper.mapUserDtos(this.userDao.getAll());
//    }
}
