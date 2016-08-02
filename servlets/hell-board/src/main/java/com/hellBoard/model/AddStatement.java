package main.java.com.hellBoard.model;

import main.java.com.hellBoard.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by woollymn on 16. 8. 3.
 */
public class AddStatement implements StatementStrategy {
    User user;

    public AddStatement(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("INSERT INTO users(id, name, password) VALUES(?, ?, ?)");

        ps.setString(1, user.getUserId());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getPassword());

        return ps;
    }
}
