package dao;

import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {
    public List<User> getAllUser();
    public void saveUser(User user);
}
