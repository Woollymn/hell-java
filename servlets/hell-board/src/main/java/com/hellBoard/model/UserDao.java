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
public class UserDao extends Dao {

    public User createUser(final User user) throws SQLException {
        //User.getInstance().add(user);
        this.jdbcContext.executeSqlFromObject("INSERT INTO users(id, name, password) VALUES(?, ?, ?)", user);

        return user;
    }

    public User findUser(final String userId) {
        Set<User> users = User.getInstance();

        for(User user : users) {
            if (userId.equals(user.getUserId())) {
                return user;
            }
        }

        return null;
    }

    public User updateUser(final User updatedUser) throws SQLException {
        String userId = updatedUser.getUserId();
        this.deleteUserByUserId(userId);
        this.createUser(updatedUser);

        return this.findUser(userId);
    }

    public boolean deleteUserByUserId(final String userId) {
        User user = this.findUser(userId);

        return User.getInstance().remove(user);
    }
}