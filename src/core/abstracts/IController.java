package core.abstracts;

import entities.concretes.User;
import java.util.List;

public interface IController {
    boolean controlName(User user);

    boolean controlSurname(User user);

    boolean controlMail(User user);

    boolean controlUsedMail(List<User> users, User user);

    boolean controlPhoneNumber(User user);

    boolean controlPassword(User user);
}
