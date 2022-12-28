package org.example.dao;

import org.example.config.JDBCConfig;
import org.example.enums.Gender;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public final Connection connection;

    public UserDaoImpl() throws SQLException {
        this.connection = new JDBCConfig().getConnection();
    }

    @Override
    public String createTable() {
        String sql = """
                creat table users(
                id serial primary key,
                name varchar (50),
                age int,
                email varchar,
                phoneNumber varchar )                
                """;
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public String saveStudent(User user) {
        String sql = """
                insert into users(name,age,gender,email,phoneNumber)value(?,?,?,?,?);
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public String dropTable() {
        String sql = "drop table users";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
return "successfully drop table";

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(Long id) {
        String sql = """
                select * from users where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("ERROR NOT ID");
            }
            User user = new User();
            user.setId(resultSet.getLong(1));
            user.setName(resultSet.getString(2));
            user.setAge(resultSet.getInt(3));
            user.setEmail(resultSet.getString(5));
            user.setPhoneNumber(resultSet.getString(6));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User deleteById(Long id) {
        String sql = "delete from users where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public String cleanTable() {
        String sql = "truncate users";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            return "successfully clean";


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "FAILED CLEAN";
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from users";
        List<User> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt(2));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                list.add(user);
                return list;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateStudent(Long id, User user) {
        String sql =
                "update set name = ?,age = ?, email = ?, phoneNumber = ?,where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setLong(5, user.getId());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
