package dataAccess.concretes;

import dataAccess.abstracts.IDbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper implements IDbHelper {
    private String username = "root";
    private String password = "12345";
    private String dbUrl = "jdbc:mysql://localhost:3306/user";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    @Override
    public void showErrorMessage(SQLException sqlException) {
        System.out.println("Error: " + sqlException.getMessage());
        System.out.println("Error: " + sqlException.getErrorCode());
    }
}
