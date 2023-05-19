import business.abstracts.UserService;
import business.concretes.UserManager;
import core.concertes.ControlManager;
import dataAccess.concretes.DbHelper;
import dataAccess.concretes.UserDao;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserManager(new UserDao(new DbHelper()), new ControlManager());

        // User Add
        //    userService.add(new User("Eyüp","Ayrı","5383720782","aliayri52@gmail.com","523452"));


        // User Login
        //    userService.userLogin();




    }
}