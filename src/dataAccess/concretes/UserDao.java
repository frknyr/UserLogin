package dataAccess.concretes;

import dataAccess.abstracts.IDbHelper;
import dataAccess.abstracts.IUserDao;
import entities.concretes.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    private IDbHelper dbHelper;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet;

    public UserDao(IDbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public void add(User user) throws SQLException {
        String sql = "INSERT INTO USER(NAME,SURNAME,PHONENUMBER,EMAİL,PASSWORD) VALUES (?,?,?,?,?)";
        try {
            connection = dbHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            int result = preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        System.out.println("Kayıt oluşturuldu");
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User get(int id) throws SQLException {
        User user;
        for (User userControl : userAll()) {
            if (userControl.getUserId() == id) {
                user = new User(userControl.getName(), userControl.getSurname(), userControl.getPhoneNumber(),
                        userControl.getEmail(), userControl.getPassword());
                System.out.println("Kullanıcı bulundu: " + userControl.getName() + " " + userControl.getSurname());

                return user;
            }

        }
        System.out.println("Kullanıcı bulunamadı !");
        return null;
    }

    @Override
    public List<User> userAll() throws SQLException {
        User user;
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM USER";

        try {
            connection = dbHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User(resultSet.getString("NAME"), resultSet.getString("SURNAME"),
                        resultSet.getString("PHONENUMBER"), resultSet.getString("EMAİL"),
                        resultSet.getString("PASSWORD"), resultSet.getInt("USERID"));
                users.add(user);
            }
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            preparedStatement.close();
            resultSet.close();
            connection.close();
        }
        return users;
    }
}
