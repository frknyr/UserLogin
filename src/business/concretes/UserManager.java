package business.concretes;

import business.abstracts.UserService;
import core.abstracts.IController;
import dataAccess.abstracts.IUserDao;
import entities.concretes.User;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserManager implements UserService {
    private IUserDao userDao;
    private IController controller;

    public UserManager(IUserDao userDao, IController controller) {
        this.userDao = userDao;
        this.controller = controller;
    }

    @Override
    public void add(User user) throws SQLException {
        // Tüm hata olasılıkları dahil edilmedi
        if (!controller.controlName(user) || !controller.controlSurname(user) || !controller.controlMail(user)
                || !controller.controlPhoneNumber(user) || !controller.controlPassword(user)) {
            System.out.println("Girmiş olduğunuz bilgileri kontrol ediniz !");
            return;
        }

        if (!controller.controlUsedMail(userDao.userAll(), user)) {
            System.out.println("E-mail kullanılıyor !");
        } else {
            System.out.println("Kayıt başarılı !");
            userDao.add(user);
        }

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void userLogin() throws SQLException {
        String email;
        String password;

        Scanner scanner = new Scanner(System.in);
        System.out.print("E-mail: ");
        email = scanner.next();
        System.out.print("Password: ");
        password = scanner.next();

        for (User userControl : userDao.userAll()) {

            if (userControl.getEmail().equals(email) && userControl.getPassword().equals(password)) {
                System.out.println("Giriş başarılı");
            } else {
                System.out.println("Giriş bilgilerinizi kontrol ediniz !");
            }
        }

    }

    @Override
    public User get(int id) throws SQLException {
        return userDao.get(id);
    }

    @Override
    public List<User> userAll() throws SQLException {
        return userDao.userAll();
    }
}

