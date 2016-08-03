package main.java.com.hellBoard.util.db;

import main.java.com.hellBoard.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hkkang on 2016. 8. 3..
 */
public class JdbcContext {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void workWithStatementStrategy(StatementStrategy stmt) {
        try (Connection c = this.dataSource.getConnection();
             PreparedStatement ps = stmt.makePreparedStatement(c)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // boolean으로 결과값 변경 필요할 듯
    public void executeSql(final String query) {
        this.workWithStatementStrategy(c -> c.prepareStatement(query));
    }

    // boolean으로 결과값 변경 필요할 듯
    public void executeSqlFromObject(String query, Object object) {
        this.workWithStatementStrategy(
            c -> {
                PreparedStatement ps = c.prepareStatement(query);

                ps.setString(1, ((User) object).getUserId());
                ps.setString(2, ((User) object).getUserName());
                ps.setString(3, ((User) object).getPassword());

                return ps;
            }
        );
    }
}
