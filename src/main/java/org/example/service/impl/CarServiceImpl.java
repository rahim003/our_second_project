package org.example.service.impl;

import org.example.dao.CarDaoImpl;
import org.example.model.Car;
import org.example.service.CarService;

import java.sql.SQLException;
import java.util.List;

public class CarServiceImpl implements CarService {
    CarDaoImpl carDao = new CarDaoImpl();

    public CarServiceImpl() throws SQLException {
    }

    @Override
    public String createTable() {
        return carDao.createTable();
    }

    @Override
    public String saveStudent(Car car) {
        return carDao.saveStudent(car);
    }

    @Override
    public String dropTable() {

        return carDao.dropTable();
    }

    @Override
    public Car findById(Long id) {
        return carDao.findById(id);
    }

    @Override
    public Car deleteById(Long id) {
        return carDao.deleteById(id);
    }

    @Override
    public String cleanTable() {
        return carDao.cleanTable();
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car updateStudent(Long id, Car car) {
        return carDao.updateStudent(id, car);
    }
}
