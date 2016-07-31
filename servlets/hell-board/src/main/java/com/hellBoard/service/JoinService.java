package main.java.com.hellBoard.service;

import main.java.com.hellBoard.entity.User;
import main.java.com.hellBoard.model.UserDao;

/**
 * Created by hkkang on 2016. 7. 27..
 */
public class JoinService {
    public User addUser(String signUpId, String signUpPassword, String signUpName) {
        User signUpUser = new User(signUpId, signUpPassword, signUpName);
        UserDao.createUser(signUpUser);

        return signUpUser;
    }
}