package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUser() {

        return userDao.getAllUser();
    }
}
