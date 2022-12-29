package org.example.service.impl;

import org.example.dao.UserDaoImpl;
import org.example.model.User;
import org.example.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDaoImpl = new UserDaoImpl();

    public UserServiceImpl() throws SQLException {
    }

    @Override
    public String createTable() {
        return userDaoImpl.createTable();
    }

    @Override
    public String saveStudent(User user) {
        return userDaoImpl.saveStudent(user);
    }

    @Override
    public String dropTable() {
        return userDaoImpl.dropTable();
    }

    @Override
    public User findById(Long id) {
        return userDaoImpl.findById(id);
    }

    @Override
    public User deleteById(Long id) {
        return userDaoImpl.deleteById(id);
    }

    @Override
    public String cleanTable() {
        return userDaoImpl.cleanTable();
    }

    @Override
    public List<User> findAll() {
        return userDaoImpl.findAll();
    }

    @Override
    public User updateStudent(Long id, User user) {
        return userDaoImpl.updateStudent(id,user);
    }
}
