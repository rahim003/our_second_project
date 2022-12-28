package org.example.dao;

import org.example.model.Car;

import java.util.List;

public interface CarDao {
    String createTable();

    String saveStudent(Car car);

    String dropTable();

    Car findById(Long id);

    Car deleteById(Long id);

    String cleanTable();

    List<Car> findAll();

    Car updateStudent(Long id, Car car);
}
