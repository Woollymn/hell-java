package com.hell_board.service;


import com.hell_board.data.dao.ContentDao;
import com.hell_board.data.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContentService {

    @Autowired
    private ContentDao contentDao;

    public Content createContent(Content newContent) {
        return this.contentDao.createContent(newContent);
    }

    public List<Content> findAll() {
        return Content.getInstance();
    }

    public Content findContentByContentNo(long contentNo) {
        return this.contentDao.findContentByContentNo(contentNo);
    }

    public Content viewContentByContentNo(long contentNo) {
        Content content = this.contentDao.findContentByContentNo(contentNo);

        if (content != null) {
            long viewCount = content.getViewCount() + 1;
            content.setViewCount(viewCount);
        }

        return content;
    }

    public void updateContent(Content content) {
        this.contentDao.updateContent(content);
    }

    public boolean deleteContentByContentNo(long contentNo) {
        return this.contentDao.deleteContentByContentNo(contentNo);
    }
}
