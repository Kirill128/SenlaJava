package eu.it.academy.dao;

import org.springframework.stereotype.Repository;
import eu.it.academy.api.dao.IPetDao;
import eu.it.academy.entities.Pet;

@Repository
public class PetDao extends AGenericDao<Pet> implements IPetDao {

    public PetDao() {
        super(Pet.class);
    }
}
