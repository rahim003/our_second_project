package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {
    String createTable();

    String saveStudent(User user);

    String dropTable();

    User findById(Long id);

    User deleteById(Long id);

    String cleanTable();

    List<User> findAll();

    User updateStudent(Long id, User user);
}
