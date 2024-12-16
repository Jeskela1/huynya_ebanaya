package dao;

import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<User> getAllUser() {

        return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }
}
