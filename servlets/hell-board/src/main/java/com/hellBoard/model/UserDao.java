package main.java.com.hellBoard.model;

import main.java.com.hellBoard.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by hkkang on 2016. 7. 25..
 */
public class UserDao {
    private DataSource dataSource;

    private UserDao() {}

    public static UserDao userDao(DataSource dataSource) {
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource);

        return userDao;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User createUser(User user) throws SQLException {
        Connection c = this.dataSource.getConnection();
        User.getInstance().add(user);

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
}