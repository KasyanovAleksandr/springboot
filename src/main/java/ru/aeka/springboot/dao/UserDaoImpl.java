package ru.aeka.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.aeka.springboot.model.User;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void updateUser(int id, User user) {
        User findedUser = entityManager.find(User.class, id);

        findedUser.setAge(user.getAge());
        findedUser.setName(user.getName());
        findedUser.setSurname(user.getSurname());
    }

    @Override
    public User getUserAtId(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(getUserAtId(id));

    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

}
