package com.hell_board.dao;

import main.java.com.hellBoard.entity.User;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by hkkang on 2016. 7. 25..
 */
public class UserDao extends Dao {

    public UserDao(DataSource dataSource) {
        super(dataSource);
    }

    public int createUser(final User user) throws SQLException {
        //User.getInstance().add(user);
        return this.jdbcContext.executeSql(
                String.join("\n"
                        , "INSERT INTO PUBLIC.USER(userId, userName, password)"
                        , "VALUES (?, ?, ?)"
                )
        );
    }

    public User findUser(final User user) {
        return this.jdbcContext.executeSqlFromObject(
                String.join("\n"
                        , "SELECT userNo, userId, userName, password"
                        , "  FROM PUBLIC.USER"
                        , " WHERE userId = ?"
                        , "   AND password = ?"
                ), user
        );
    }
/*
    public User updateUser(final User updatedUser) throws SQLException {
        String userId = updatedUser.getUserId();
        String userPassword = updatedUser.getPassword();
        this.deleteUserByUserId(userId, userPassword);
        this.createUser(updatedUser);

        return this.findUser(userId);
    }

    public boolean deleteUserByUserId(final String userId, final String userPassword) {
        User user = this.findUser(userId, userPassword);

        return User.getInstance().remove(user);
    }
*/
}