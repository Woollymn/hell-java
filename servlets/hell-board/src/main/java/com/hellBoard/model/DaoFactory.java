package main.java.com.hellBoard.model;

import javax.sql.DataSource;

/**
 * Created by woollymn on 16. 8. 2.
 */
public class DaoFactory {
    private static DaoFactory instance;

    private DaoFactory() {}

    public UserDao userDao() {
        return UserDao.userDao(this.dataSource());
    }

    public ContentDao contentDao() {
        return new ContentDao();
    }

    private DataSource dataSource() {
        return new H2DriverDataSource();
    }
    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }

        return instance;
    }
}
