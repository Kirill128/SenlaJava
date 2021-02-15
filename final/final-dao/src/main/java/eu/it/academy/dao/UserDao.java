package eu.it.academy.dao;

import org.springframework.stereotype.Repository;
import eu.it.academy.api.dao.IUserDao;
import eu.it.academy.entities.User;

@Repository
public class UserDao extends AGenericDao<User> implements IUserDao {

    public UserDao() {
        super(User.class);
    }
}
