package com.hell_board.dao;

import main.java.com.hellBoard.util.db.H2DriverDataSource;

import javax.sql.DataSource;

/**
 * Created by woollymn on 16. 8. 2.
 */
public class DaoFactory {

    public UserDao userDao() {
        return new UserDao(this.dataSource());
    }

    public ContentDao contentDao() {
        return new ContentDao(this.dataSource());
    }

    private DataSource dataSource() {
        return H2DriverDataSource.getInstance();
    }
}
