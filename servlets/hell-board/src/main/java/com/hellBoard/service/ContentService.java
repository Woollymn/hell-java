package main.java.com.hellBoard.service;

import main.java.com.hellBoard.entity.Content;
import main.java.com.hellBoard.model.ContentDao;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by hkkang on 2016. 7. 27..
 */
public class ContentService {
    public Content createContent(Content newContent) {
        return ContentDao.createContent(newContent);
    }

    public List<Content> findAll() {
        return Content.getInstance();
    }

    public Content findContentByContentNo(long contentNo) {
        return ContentDao.findContentByContentNo(contentNo);
    }

    public Content viewContentByContentNo(long contentNo) {
        Content content = ContentDao.findContentByContentNo(contentNo);

        if (content != null) {
            long viewCount = content.getViewCount() + 1;
            content.setViewCount(viewCount);
        }

        return content;
    }

    public void updateContent(Content content) {
        ContentDao.updateContent(content);
    }

    public boolean deleteContentByContentNo(long contentNo) {
        return ContentDao.deleteContentByContentNo(contentNo);
    }
}
