package com.hell_board.data.dao;


import com.hell_board.data.domain.Content;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ContentDao {

    private JdbcTemplate jdbcTemplate;

    public ContentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Content createContent(Content content) {
        Content.getInstance().add(content);
        //this.jdbcContext.executeSqlFromObject("", content);

        return content;
    }

    public Content findContentByContentNo(long contentNo) {
        List<Content> contents = Content.getInstance();

        for(Content content : contents) {
            if (contentNo == content.getContentNo()) {
                return content;
            }
        }

        return null;
    }

    public Content updateContent(Content updatedContent) {
        long contentNo = updatedContent.getContentNo();

        this.deleteContentByContentNo(contentNo);
        this.createContent(updatedContent);

        return this.findContentByContentNo(contentNo);
    }

    public boolean deleteContentByContentNo(long contentNo) {
        Content content = this.findContentByContentNo(contentNo);

        return Content.getInstance().remove(content);
    }
}
