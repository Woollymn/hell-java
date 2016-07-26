package com.hellBoard.service;

import com.hellBoard.entity.User;
import com.hellBoard.model.UserDao;

/**
 * Created by woollymn on 16. 7. 25.
 */
public class LoginService {
    public User findByPassword(String userId, String userPassword) {

        User findedUser = UserDao.findUser(userId);

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
