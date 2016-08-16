package com.hell_board.entity;

import com.hell_board.exception.IdPasswordNoMatchingException;

import java.util.Date;

public class Member {

    private Long id;
    private String email;
    private String password;
    private String name;
    private Date registerDate;

    public Member(Long id, String email, String password, String name, Date registerDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDate = registerDate;
    }

    public Member(String email, String password, String name, Date registerDate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDate = registerDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!password.equals(oldPassword)) {
            throw new IdPasswordNoMatchingException();
        }

        this.password = newPassword;
    }
}