package eu.it.academy.api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import eu.it.academy.api.dto.UserDto;
import eu.it.academy.entities.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public User mapUser(UserDto source) {
        return User.builder()
                .id(source.getId())
                .username(source.getUsername())
                .salary(source.getSalary())
                .password(source.getPassword())
                .build();
    }

    public UserDto mapUserDto(User source) {
        return UserDto.builder()
                .id(source.getId())
                .username(source.getUserName())
                .salary(source.getSalary())
                .password(source.getPassword())
                .build();
    }

    public List<User> mapUsers(List<UserDto> source) {
        return source.stream().map(UserMapper::mapUser).collect(Collectors.toList());
    }
    
    public List<UserDto> mapUserDtos(List<User> source) {
        return source.stream().map(UserMapper::mapUserDto).collect(Collectors.toList());
    }
}
