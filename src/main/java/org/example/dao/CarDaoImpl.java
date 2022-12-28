package org.example.dao;

import org.example.config.JDBCConfig;
import org.example.model.Car;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CarDaoImpl implements CarDao {
    public final Connection connection;

    public CarDaoImpl() throws SQLException {
        this.connection = new JDBCConfig().getConnection();
    }

    //create table database
    @Override
    public String createTable() {
        return null;
    }

    @Override
    public String saveStudent(Car car) {
        return null;
    }

    @Override
    public String dropTable() {
        return null;
    }

    @Override
    public Car findById(Long id) {
        return null;
    }

    @Override
    public Car deleteById(Long id) {
        return null;
    }

    @Override
    public String cleanTable() {
        return null;
    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public Car updateStudent(Long id, Car car) {
        return null;
    }
}
