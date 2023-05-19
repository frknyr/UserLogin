package dataAccess.abstracts;

import dataAccess.concretes.DbHelper;
import entities.concretes.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    void add(User user) throws SQLException;

    void delete(User user) throws SQLException;

    void update(User user) throws SQLException;

    User get(int id) throws SQLException;

    List<User> userAll() throws SQLException;


}
