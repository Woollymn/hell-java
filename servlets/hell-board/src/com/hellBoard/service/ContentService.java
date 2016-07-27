package com.hellBoard.service;

import com.hellBoard.entity.Content;
import com.hellBoard.model.ContentDao;

import java.time.LocalDateTime;

/**
 * Created by hkkang on 2016. 7. 27..
 */
public class ContentService {
    public void createContent() {
        ContentDao.createContent(new Content("hkkang", "테스트", "testtesttesttest", LocalDateTime.now()));
    }

    public Content findContentByContentNo(long contentNo) {
        return ContentDao.findContentByContentNo(contentNo);
    }

    public Content viewContentByContentNo(long contentNo) {
        Content content = ContentDao.findContentByContentNo(contentNo);
        long viewCount = content.getViewCount() + 1;

        content.setViewCount(viewCount);

        return content;
    }
}
