package storage;

import entity.Phone;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserStorage {
    public void save(User user) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "vandal")) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into users values(?,?,?,?)");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4,user.getPhones().toString());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> findAll() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres"
                        , "postgres", "vandal")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                String firstName = resultSet.getString(1);
                String secondName = resultSet.getString(2);
                String email = resultSet.getString(3);
                List<Phone> phones = resultSet.getObject(4,List<String> phones);
                User user = new User(firstName,secondName,email,phones);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }
    public Optional<User> findByFirstName(String firstName) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres"
                        , "postgres", "vandal")) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where first_name = ?");
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String secondName = resultSet.getString(2);
            String email = resultSet.getString(3);
            String phone = resultSet.getString(4);
            User user = new User(firstName,secondName,email,phone);
            return Optional.of(user);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }
    public Optional<User> findBySecondName(String secondName) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres"
                        , "postgres", "vandal")) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where second_name = ?");
            preparedStatement.setString(1, secondName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String firstName = resultSet.getString(1);
            String email = resultSet.getString(3);
            String phone = resultSet.getString(4);
            User user = new User(firstName,secondName,email,phone);
            return Optional.of(user);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }
    public Optional<User> findByEmail(String email) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres"
                        , "postgres", "vandal")) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String firstName = resultSet.getString(1);
            String secondName = resultSet.getString(2);
            String phone = resultSet.getString(4);
            User user = new User(firstName,secondName,email,phone);
            return Optional.of(user);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }
    public Optional<User> findByPhone(String phone) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres"
                        , "postgres", "vandal")) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where phones = ?");
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String firstName = resultSet.getString(1);
            String secondName = resultSet.getString(2);
            String email = resultSet.getString(3);
            User user = new User(firstName,secondName,email,phone);
            return Optional.of(user);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }
    public void deleteAll() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres"
                        , "postgres", "vandal")) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users");
            preparedStatement.execute();
        } catch (SQLException e) {

        }
    }
    public void deleteByFirstName(String firstName) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres"
                        , "postgres", "vandal")) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where first_name = ?");
            preparedStatement.setString(1, firstName);
            preparedStatement.execute();
        } catch (SQLException e) {

        }
    }
    public void deleteBySecondName(String secondName) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres"
                        , "postgres", "vandal")) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where second_name = ?");
            preparedStatement.setString(1, secondName);
            preparedStatement.execute();
        } catch (SQLException e) {

        }
    }
    public void deleteByEmail(String email) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres"
                        , "postgres", "vandal")) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where email = ?");
            preparedStatement.setString(1, email);
            preparedStatement.execute();
        } catch (SQLException e) {

        }
    }
    public void deleteByPhone(String phone) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres"
                        , "postgres", "vandal")) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where phones = ?");
            preparedStatement.setString(1, phone);
            preparedStatement.execute();
        } catch (SQLException e) {

        }
    }
}
