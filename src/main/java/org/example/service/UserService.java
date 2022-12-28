package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    String createTable();

    String saveStudent(User user);

    String dropTable();

    User findById(Long id);

    User deleteById(Long id);

    String cleanTable();

    List<User> findAll();

    User updateStudent(Long id, User user);
}
