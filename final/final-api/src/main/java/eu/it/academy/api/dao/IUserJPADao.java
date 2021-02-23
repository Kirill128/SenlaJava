package eu.it.academy.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.it.academy.entities.User;

public interface IUserJPADao extends JpaRepository<User, Integer> {

    User findByFirstName(String finstName);
}
