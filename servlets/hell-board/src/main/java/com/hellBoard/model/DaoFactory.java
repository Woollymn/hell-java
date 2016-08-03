package main.java.com.hellBoard.model;

import main.java.com.hellBoard.util.db.H2DriverDataSource;

import javax.sql.DataSource;

/**
 * Created by woollymn on 16. 8. 2.
 */
public class DaoFactory {

    public UserDao userDao() {
        return (UserDao) new Dao(this.dataSource());
    }

    public ContentDao contentDao() {
        return (ContentDao) new Dao(this.dataSource());
    }

    private DataSource dataSource() {
        return H2DriverDataSource.getInstance();
    }
}
