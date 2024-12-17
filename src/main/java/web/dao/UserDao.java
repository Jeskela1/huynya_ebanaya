package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;


public interface UserDao {
    void save(User user);
    List<User> getAllUser();
    Optional<User> getUserById(Long id);
    void updateUser(User user);
    void deleteById(Long id);
}
