package business.abstracts;

import entities.concretes.User;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void add(User user) throws SQLException;

    void delete(User user);

    void update(User user);

    void userLogin() throws SQLException;

    User get(int id) throws SQLException;

    List<User> userAll() throws SQLException;
}
