package com.hell_board.data.dao;


import com.hell_board.data.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int createUser(final User user) {
        return this.jdbcTemplate.update(
                String.join("\n"
                        , "INSERT INTO PUBLIC.USER ("
                        , "       userId"
                        , "     , userName"
                        , "     , password"
                        , "     ) "
                        , "VALUES (?, ?, ?)"
                ),
                user.getUserId(),
                user.getUserName(),
                user.getPassword()
        );
    }

    public User findUser(final User user) {
        return this.jdbcTemplate.queryForObject(
                String.join("\n"
                        , "SELECT userNo, userId, userName, password"
                        , "  FROM PUBLIC.USER"
                        , " WHERE userId = ?"
                        , "   AND password = ?"
                ),
                (resultSet, rowNum) -> {

                    User user1 = new User(
                            resultSet.getLong("userNo"),
                            resultSet.getString("userId"),
                            resultSet.getString("userName"),
                            resultSet.getString("password"));

                    return user1;
                },
                user.getUserId(),
                user.getPassword()
        );
    }

    public int updateUser(final User user) {
        return this.jdbcTemplate.update(
                String.join("\n"
                        , "UPDATE PUBLIC.USER"
                        , "   SET userId = ?"
                        , "     , userName = ?"
                        , "     , password = ?"
                        , " WHERE userNo = ?"
                ),
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getUserNo()
        );
    }

    public int deleteUser(final User user) {
        return this.jdbcTemplate.update(
                String.join("\n"
                        , "DELETE PUBLIC.USER"
                        , " WHERE userNo = ?"
                ),
                user.getUserNo()
        );
    }
}