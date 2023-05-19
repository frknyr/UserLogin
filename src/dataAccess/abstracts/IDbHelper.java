package dataAccess.abstracts;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDbHelper {
    Connection getConnection() throws SQLException;

    void showErrorMessage(SQLException sqlException);

}
