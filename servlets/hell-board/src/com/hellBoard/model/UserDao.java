package com.hellBoard.model;

import com.hellBoard.entity.User;

import java.util.Set;

/**
 * Created by hkkang on 2016. 7. 25..
 */
public class UserDao {
    private Set<User> users = User.getInstance();

    /*
     * CRUD
     * Exception 처리가 부족..
     * Collection에 user가 없는데 CRUD 처리를 시도하면?
     */
    public User createUser(User user) {
        this.users.add(user);

        return user;
    }

    public User findUser(String userId) {
        for(User user : this.users) {
            if (userId.equals(user.getUserId())) {
                return user;
            }
        }

        return null;
    }

    public User updateUser(String userId, User updatedUser) {
        this.deleteUser(userId);
        this.createUser(updatedUser);

        return this.findUser(updatedUser.getUserId());
    }

    public boolean deleteUser(String userId) {
        User user = this.findUser(userId);

        return this.users.remove(user);
    }
}