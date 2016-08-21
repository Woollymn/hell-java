package com.hell_board.service;

import com.hell_board.data.dao.UserDao;
import com.hell_board.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class JoinService {

    @Autowired
    private UserDao userDao;

    public User addUser(String signUpId,
                        String signUpPassword,
                        String signUpName)
            throws SQLException {

        User signUpUser = new User(signUpId, signUpPassword, signUpName);

        return signUpUser;
    }
}