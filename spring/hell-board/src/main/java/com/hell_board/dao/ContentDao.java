package com.hell_board.dao;

import main.java.com.hellBoard.entity.Content;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by hkkang on 2016. 7. 27..
 */
public class ContentDao extends Dao {

    public ContentDao(DataSource dataSource) {
        super(dataSource);
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
