package com.hell_board.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by woollymn on 16. 7. 25.
 */
public class User {
    private static Set<User> users = new HashSet<>();

    private long userNo;
    private String userId;
    private String userName;
    private String password;

    private User() {}

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User(String userId, String password, String userName) {
        this(userId, password);
        this.userName = userName;
    }

    public User(long userNo, String userId, String password, String userName) {
        this(userId, password, userName);
        this.userNo = userNo;
    }

    public static Set<User> getInstance() {
        return users;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String toString() {
        return "userId: " + this.userId + "\n" +
                "userName: " + this.userName + "\n" +
                "password: " + this.password;
    }

    public long getUserNo() {
        return userNo;
    }
}