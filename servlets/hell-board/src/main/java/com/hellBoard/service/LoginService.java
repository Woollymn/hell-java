package main.java.com.hellBoard.service;

import main.java.com.hellBoard.entity.User;
import main.java.com.hellBoard.model.DaoFactory;
import main.java.com.hellBoard.model.UserDao;

/**
 * Created by woollymn on 16. 7. 25.
 */
public class LoginService {
    private UserDao userDao = new DaoFactory().userDao();

    public User findByPassword(String userId, String userPassword) {

        User findedUser = this.userDao.findUser(new User(userId, userPassword));

        if (findedUser == null) {
            // 에러처리
            return null;
        }

        if (!userPassword.equals(findedUser.getPassword())) {
            // 에러처리
            return null;
        }

        return findedUser;
    }
}
