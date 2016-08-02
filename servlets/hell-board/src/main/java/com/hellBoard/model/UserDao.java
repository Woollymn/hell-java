package main.java.com.hellBoard.model;

import main.java.com.hellBoard.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by hkkang on 2016. 7. 25..
 */
public class UserDao {
    private DataSource dataSource;

    private UserDao() {}

    public UserDao userDao(DataSource dataSource) {
        UserDao userDao = new UserDao();
        this.setDataSource(dataSource);

        return userDao;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User createUser(User user) throws SQLException {
        //User.getInstance().add(user);

        StatementStrategy st = new UserDaoCreateUser();
        jdbcContextWithStatementStrategy(st);

        return user;
    }

    public User findUser(String userId) {
        Set<User> users = User.getInstance();

        for(User user : users) {
            if (userId.equals(user.getUserId())) {
                return user;
            }
        }

        return null;
    }

    public User updateUser(User updatedUser) throws SQLException {
        String userId = updatedUser.getUserId();
        this.deleteUserByUserId(userId);
        this.createUser(updatedUser);

        return this.findUser(userId);
    }

    public boolean deleteUserByUserId(String userId) {
        User user = this.findUser(userId);

        return User.getInstance().remove(user);
    }

    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {

            c = this.dataSource.getConnection();
            ps = stmt.makePreparedStatement(c);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) {} }
            if (c != null) { try { c.close(); } catch (SQLException e) {} }
        }
    }
}