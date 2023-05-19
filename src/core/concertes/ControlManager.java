package core.concertes;

import core.abstracts.IController;
import entities.concretes.User;
import java.util.List;
import java.util.regex.Pattern;

public class ControlManager implements IController {

    @Override
    public boolean controlName(User user) {
        if (user.getName().length() < 2) {
            System.out.println("Ad en az iki karakterli olmalıdır.");
            return false;
        }
        return true;
    }

    @Override
    public boolean controlSurname(User user) {
        if (user.getSurname().length() < 2) {
            System.out.println("Soyad en az iki karakterli olmalıdır.");
            return false;
        }
        return true;
    }

    @Override
    public boolean controlMail(User user) {
        String mail = user.getEmail();
        boolean et = Pattern.matches(".*@.*", mail);
        boolean datCom = Pattern.matches(".*gmail.com", mail);
        if (et && datCom) {
            return true;
        } else {
            System.out.println("E-mail formatınızı kontrol ediniz!");
            return false;
        }

    }

    @Override
    public boolean controlUsedMail(List<User> users, User user) {
        for (User controlUser : users) {
            if (controlUser.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean controlPhoneNumber(User user) {
        String phoneNumber = user.getPhoneNumber();
        boolean none = Pattern.matches("0.*", phoneNumber);
        if (phoneNumber.length() == 10 && !none) {
            return true;
        }
        if (phoneNumber.length() < 10) {
            System.out.println("Telefon numaranızı kontrol ediniz!");
            return false;
        }
        if (none) {
            System.out.println("Başında 0 olmadan telefon numaranızı yazınız !");
            return false;
        }
        return false;
    }

    @Override
    public boolean controlPassword(User user) {
        if (user.getPassword().length() < 6) {
            System.out.println("Parolanız en az 6 haneli olmalıdır !");
            return false;
        }
        return true;
    }
}
