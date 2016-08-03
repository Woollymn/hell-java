package main.java.com.hellBoard.service;

import main.java.com.hellBoard.entity.Content;
import main.java.com.hellBoard.model.ContentDao;
import main.java.com.hellBoard.model.DaoFactory;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by hkkang on 2016. 7. 27..
 */
public class ContentService {
    private ContentDao contentDao = new DaoFactory().contentDao();

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
