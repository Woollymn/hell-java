package com.hell_board.data.dao;

import com.hell_board.data.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDateTime;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member findByEmail(final String email) {
        return this.jdbcTemplate.queryForObject(
                String.join("\n"
                        , "SELECT id"
                        , "     , email"
                        , "     , name"
                        , "     , password"
                        , "     , registerDate"
                        , "  FROM PUBLIC.MEMBER"
                        , " WHERE email = ?"
                ),

                (resultSet, rowNum) -> {
                    Member member = new Member(
                            resultSet.getLong("id"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("name"),
                            LocalDateTime.parse(resultSet.getString("registerDate"))
                    );

                    return member;
                },

                email
        );
    }

    public int insert(final Member member) {
        return this.jdbcTemplate.update(
                String.join("\n"
                        , "INSERT INTO PUBLIC.MEMBER ("
                        , "       email"
                        , "     , name"
                        , "     , password"
                        , "     , registerDate"
                        , "     ) "
                        , "VALUES (?, ?, ?, ?)"
                ),

                member.getEmail(),
                member.getName(),
                member.getPassword(),
                member.getRegisterDate()
        );
    }

    public int update(final Member member) {
        return this.jdbcTemplate.update(
                String.join("\n"
                        , "UPDATE PUBLIC.MEMBER"
                        , "   SET email = ?"
                        , "     , name = ?"
                        , "     , password = ?"
                        , " WHERE id = ?"
                ),

                member.getEmail(),
                member.getName(),
                member.getPassword(),
                member.getId()
        );
    }

    public int delete(final Member member) {
        return this.jdbcTemplate.update(
                String.join("\n"
                        , "DELETE PUBLIC.MEMBER"
                        , " WHERE id = ?"
                ),
                member.getId()
        );
    }
}
