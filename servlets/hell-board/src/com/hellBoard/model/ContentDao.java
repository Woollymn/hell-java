package com.hellBoard.model;

import com.hellBoard.entity.Content;

import java.util.List;

/**
 * Created by hkkang on 2016. 7. 27..
 */
public class ContentDao {
    /*
    CRUD
     */
    public static Content createContent(Content content) {
        Content.getInstance().add(content);

        return content;
    }

    public static Content findContentByContentNo(long contentNo) {
        List<Content> contents = Content.getInstance();

        for(Content content : contents) {
            if (contentNo == content.getContentNo()) {
                return content;
            }
        }

        return null;
    }

    public static Content updateContent(Content updatedContent) {
        long contentNo = updatedContent.getContentNo();

        ContentDao.deleteContentByContentNo(contentNo);
        ContentDao.createContent(updatedContent);

        return ContentDao.findContentByContentNo(contentNo);
    }

    public static boolean deleteContentByContentNo(long contentNo) {
        Content content = ContentDao.findContentByContentNo(contentNo);

        return Content.getInstance().remove(content);
    }
}
