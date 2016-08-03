package main.java.com.hellBoard.model;

import main.java.com.hellBoard.util.db.JdbcContext;

import javax.sql.DataSource;

/**
 * Created by hkkang on 2016. 8. 3..
 */
public class Dao {

    private DataSource dataSource;
    protected JdbcContext jdbcContext;

    protected Dao() {}

    public Dao(DataSource dataSource) {
        this.jdbcContext = new JdbcContext();

        this.jdbcContext.setDataSource(dataSource);
        this.dataSource = dataSource;
    }
}
