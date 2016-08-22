package com.hell_board.data.dao;


import com.hell_board.data.domain.Content;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDateTime;

public class ContentDao {

    private JdbcTemplate jdbcTemplate;

    public ContentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int create(Content content) {
        return this.jdbcTemplate.update(
                String.join("\n"
                        , "INSERT INTO PUBLIC.CONTENT ("
                        , "       userId"
                        , "       subject"
                        , "       text"
                        , "       registerDateTime"
                        , "       viewCount"
                        , "     ) "
                        , "VALUES (?, ?, ?, ?, ?)"
                ),

                content.getUserId(),
                content.getSubject(),
                content.getText(),
                content.getRegisterDateTime(),
                content.getViewCount()
        );
    }

    public Content findContentByContentNo(final long contentNo) {
        return this.jdbcTemplate.queryForObject(
                String.join("\n"
                        , "SELECT contentNo"
                        , "     , userId"
                        , "     , subject"
                        , "     , text"
                        , "     , registerDateTime"
                        , "     , viewCount"
                        , "  FROM PUBLIC.CONTENT"
                        , " WHERE contentNo = ?"
                ),

                (resultSet, rowNum) -> {
                    Content content = new Content(
                            resultSet.getLong("contentNo"),
                            resultSet.getString("userId"),
                            resultSet.getString("subject"),
                            resultSet.getString("text"),
                            LocalDateTime.parse(resultSet.getString("registerDateTime")),
                            resultSet.getLong("viewCount")
                    );

                    return content;
                },

                contentNo
        );
    }

    public int update(final Content content) {
        return this.jdbcTemplate.update(
                String.join("\n"
                        , "UPDATE PUBLIC.CONTENT"
                        , "   SET subject = ?"
                        , "     , text = ?"
                        , "     , viewCount = ?"
                        , " WHERE contentNo = ?"
                ),

                content.getSubject(),
                content.getText(),
                content.getViewCount(),
                content.getContentNo()
        );
    }

    public int delete(final Content content) {
        return this.jdbcTemplate.update(
                String.join("\n"
                        , "DELETE PUBLIC.CONTENT"
                        , " WHERE contentNo = ?"
                ),

                content.getContentNo()
        );
    }
}