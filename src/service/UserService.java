package service;


import entity.Phone;
import entity.User;
import storage.JDBCUserStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final JDBCUserStorage jdbcUserStorage = new JDBCUserStorage();

public void create(String firstName,String secondName,String email,String phones){
    User user = new User(firstName,secondName,email, phones);
    jdbcUserStorage.save(user);
}




}
