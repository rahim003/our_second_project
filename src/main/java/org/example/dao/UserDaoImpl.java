package org.example.dao;

import org.example.config.JDBCConfig;
import org.example.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public final Connection connection;

    public UserDaoImpl() throws SQLException {
        this.connection = new JDBCConfig().getConnection();
    }

    @Override
    public String createTable() {
        return null;
    }

    @Override
    public String saveStudent(User user) {
        return null;
    }

    @Override
    public String dropTable() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User deleteById(Long id) {
        return null;
    }

    @Override
    public String cleanTable() {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User updateStudent(Long id, User user) {
        return null;
    }
}
