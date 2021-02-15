package eu.it.academy.api.services;

import org.springframework.stereotype.Service;

import eu.it.academy.entities.User;

@Service
public interface IUserService {

    User findUser(int id);
}
