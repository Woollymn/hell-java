package main.java.com.hellBoard.service;

import main.java.com.hellBoard.entity.User;
import main.java.com.hellBoard.model.DaoFactory;
import main.java.com.hellBoard.model.UserDao;

import java.sql.SQLException;

/**
 * Created by hkkang on 2016. 7. 27..
 */
public class JoinService {
    private UserDao userDao = new DaoFactory().userDao();

    public User addUser(String signUpId,
                        String signUpPassword,
                        String signUpName)
            throws SQLException {

        User signUpUser = new User(signUpId, signUpPassword, signUpName);
        this.userDao.createUser(signUpUser);

        return signUpUser;
    }
}