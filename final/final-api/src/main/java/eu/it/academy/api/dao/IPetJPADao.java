package eu.it.academy.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.it.academy.entities.Pet;

public interface IPetJPADao extends JpaRepository<Pet, Integer> {

}
