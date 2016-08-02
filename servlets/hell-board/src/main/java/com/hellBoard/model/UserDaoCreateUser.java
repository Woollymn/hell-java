package main.java.com.hellBoard.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by woollymn on 16. 8. 3.
 */
public class UserDaoCreateUser implements StatementStrategy {
    @Override
    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("");
        return ps;
    }
}
