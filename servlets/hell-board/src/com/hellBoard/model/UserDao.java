package com.hellBoard.model;

import com.hellBoard.entity.User;

import java.util.Set;

/**
 * Created by hkkang on 2016. 7. 25..
 */
public class UserDao {
    /*
     * CRUD
     * Exception 처리가 부족..
     * Collection에 user가 없는데 CRUD 처리를 시도하면?
     */
    public static User createUser(User user) {
        User.getInstance().add(user);

        return user;
    }

    public static User findUser(String userId) {
        Set<User> users = User.getInstance();

        for(User user : users) {
            if (userId.equals(user.getUserId())) {
                return user;
            }
        }

        return null;
    }

    public static User updateUser(String userId, User updatedUser) {
        UserDao.deleteUser(userId);
        UserDao.createUser(updatedUser);

        return UserDao.findUser(updatedUser.getUserId());
    }

    public static boolean deleteUser(String userId) {
        User user = UserDao.findUser(userId);

        return User.getInstance().remove(user);
    }
}