package com.hellBoard.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by woollymn on 16. 7. 25.
 */
public class User {
    private static Set<User> users = new HashSet<>();

    // private Long userNo; // 나중에 추가하자..
    private String userId;
    private String userName;
    private String password;

    private User() {}

    public User(String userId, String password, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
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
}