package ru.aeka.springboot.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.aeka.springboot.dao.UserDao;
import ru.aeka.springboot.model.User;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    public User getUserAtId(int id) {
        return userDao.getUserAtId(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void removeUserById(int id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


}
