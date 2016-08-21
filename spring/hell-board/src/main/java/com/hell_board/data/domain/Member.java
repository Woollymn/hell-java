package com.hell_board.data.domain;

import java.time.LocalDateTime;

public class Member {

    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime registerDate;

    public Member(Long id, String email, String password, String name, LocalDateTime registerDate) {
        this(email, password, name, registerDate);
        this.id = id;
    }

    public Member(String email, String password, String name, LocalDateTime registerDate) {
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

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }
}