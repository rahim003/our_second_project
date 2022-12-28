package org.example.dao;

import org.example.config.JDBCConfig;
import org.example.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    public final Connection connection;

    public CarDaoImpl() throws SQLException {
        this.connection = new JDBCConfig().getConnection();
    }

    //create table database
    @Override
    public String createTable() {
        String sql = """
                create table cars(
                id serial primary key,
                name varchar(50),
                colour  varchar(50),
                yearOfIssue int not null,
                price decimal ,
                )
                """;
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            return "successfully create table";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "FAILED CREATE TABLE";
    }

    @Override
    public String saveStudent(Car car) {
        String sql = """
                insert into cars(name,colour,yearOfIssue,price)values(?,?,?,?,?)
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getColour());
            preparedStatement.setInt(3, car.getYearOfIssue());
            preparedStatement.setInt(4, car.getPrice());
            preparedStatement.execute();
            return "successfully save cars";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "FAILED SAVE CARS";
    }

    @Override
    public String dropTable() {
        String sql = """
                drop table cars
                """;
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            return "successfully drop tables";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "FAILED DROP";
    }

    @Override
    public Car findById(Long id) {
        String sql = """
                select * from cars where id=?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("THIS ID NOT FOUND");
            }
            Car car = new Car();
            car.setId(resultSet.getLong(1));
            car.setName(resultSet.getString(2));
            car.setColour(resultSet.getString(3));
            car.setYearOfIssue(resultSet.getInt(4));
            car.setPrice(resultSet.getInt(6));
            return car;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Car deleteById(Long id) {
        String sql = """
                delete from cars where id =?
                """;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.execute();
            return new Car();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String cleanTable() {
        String sql = "truncate cars";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            return "successfully clean cars";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "FAILED CLEAN CAR";
    }

    @Override
    public List<Car> findAll() {
        String sql = "select * from cars";
        List<Car> cars = new ArrayList<>();
        try (Statement preparedStatement = connection.createStatement()) {
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getLong(1));
                car.setName(resultSet.getString("name"));
                car.setColour(resultSet.getString("colour"));
                car.setYearOfIssue(resultSet.getInt(4));

                car.setPrice(resultSet.getInt(6));
                cars.add(car);
                return cars;

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Car updateStudent(Long id, Car car) {
        String sql = "update cars set name=?,colour =?,yearOfIssue=?,price=? where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getColour());
            preparedStatement.setInt(3, car.getYearOfIssue());
            preparedStatement.setInt(4, car.getPrice());
            return car;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
