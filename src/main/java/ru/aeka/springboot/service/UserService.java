package ru.aeka.springboot.service;

import ru.aeka.springboot.model.User;


import java.util.List;

public interface UserService {

    void updateUser(int id, User user);

    Object getUserAtId(int id);

    void saveUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();
}