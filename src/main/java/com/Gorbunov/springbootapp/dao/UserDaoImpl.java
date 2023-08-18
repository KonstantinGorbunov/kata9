package com.Gorbunov.springbootapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.Gorbunov.springbootapp.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<User> getUserList() {
        return entityManager.createQuery(" FROM User ").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return (User) entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User where id = :id").setParameter("id", id).executeUpdate();
    }
}
