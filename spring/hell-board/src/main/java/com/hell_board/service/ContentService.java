package com.hell_board.service;


import com.hell_board.data.dao.ContentDao;
import com.hell_board.data.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.Objects.isNull;

public class ContentService {

    @Autowired
    private ContentDao contentDao;

    public int createContent(Content newContent) {
        return this.contentDao.create(newContent);
    }

    public List<Content> findAll() {
        return Content.getInstance();
    }

    public Content findContentByContentNo(long contentNo) {
        return this.contentDao.findContentByContentNo(contentNo);
    }

    public Content viewContentByContentNo(long contentNo) {
        Content content = this.contentDao.findContentByContentNo(contentNo);

        if (isNull(content)) {
            long viewCount = content.getViewCount() + 1;
            content.setViewCount(viewCount);
        }

        return content;
    }

    public int update(Content content) {
        return this.contentDao.update(content);
    }

    public int delete(Content content) {
        return this.contentDao.delete(content);
    }
}
