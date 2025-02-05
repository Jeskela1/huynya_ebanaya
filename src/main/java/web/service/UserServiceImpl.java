package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}
