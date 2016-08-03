package main.java.com.hellBoard.util.db;

import main.java.com.hellBoard.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hkkang on 2016. 8. 3..
 */
public class JdbcContext {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User workWithStatementStrategy(StatementStrategy stmt) {

        User user = null;

        try (Connection c = this.dataSource.getConnection();
             PreparedStatement ps = stmt.makePreparedStatement(c)) {

            ResultSet rs = ps.executeQuery();

            user = new User(rs.getLong("userNo"),
                    rs.getString("userId"),
                    rs.getString("password"),
                    rs.getString("userName"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public int executeUpdate(StatementStrategy stmt) {

        int rs = 0;

        try (Connection c = this.dataSource.getConnection();
             PreparedStatement ps = stmt.makePreparedStatement(c)) {

            rs = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public int executeSql(final String query) {
        return this.executeUpdate(
            c -> {
                PreparedStatement ps = c.prepareStatement(query);

                ps.setString(1, "admin1");
                ps.setString(2, "관리자");
                ps.setString(3, "1234");

                return ps;
            }
        );
    }

    public User executeSqlFromObject(final String query, final Object object) {
        return this.workWithStatementStrategy(
            c -> {
                PreparedStatement ps = c.prepareStatement(query);

                ps.setString(1, ((User)object).getUserId());
                ps.setString(2, ((User)object).getPassword());

                return ps;
            }
        );
    }
}
