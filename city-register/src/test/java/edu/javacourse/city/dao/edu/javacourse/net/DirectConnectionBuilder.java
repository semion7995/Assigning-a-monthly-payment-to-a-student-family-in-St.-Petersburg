package edu.javacourse.city.dao.edu.javacourse.net;

import edu.javacourse.city.dao.ConnectionBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DirectConnectionBuilder implements ConnectionBuilder {
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/city_register", "postgres", "2134");
    }
}
