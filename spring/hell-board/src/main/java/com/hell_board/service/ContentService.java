package com.hell_board.service;


import com.hell_board.dao.ContentDao;
import com.hell_board.data.request.ContentRequest;
import com.hell_board.domain.Content;
import com.hell_board.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

public class ContentService {

    @Autowired
    private ContentDao contentDao;

    public int create(Member member, ContentRequest contentRequest) {

        int resultCount = 0;

        if (!isNull(member)) {
            String email = contentRequest.getEmail();
            String subject = contentRequest.getSubject();
            String text = contentRequest.getText();
            LocalDateTime registerDateTime = contentRequest.getRegisterDateTime();

            Content content = new Content(email, subject, text, registerDateTime);
            resultCount = this.contentDao.create(content);
        }

        return resultCount;
    }

    public List<Content> findAll() {
        return Content.getInstance();
    }

    public Content findContentByContentNo(long contentNo) {
        return this.contentDao.findContentByContentNo(contentNo);
    }

    public Content viewContentByContentNo(long contentNo) {
        Content content = this.contentDao.findContentByContentNo(contentNo);

        if (!isNull(content)) {
            long viewCount = content.getViewCount() + 1;
            content.setViewCount(viewCount);
        }

        return content;
    }

    public int update(ContentRequest contentRequest) {
        long contentNo = contentRequest.getContentNo();
        String subject = contentRequest.getSubject();
        String text = contentRequest.getText();

        Content content = this.findContentByContentNo(contentNo);
        content.setSubject(subject);
        content.setText(text);

        return this.contentDao.update(content);
    }

    public int delete(long contentNo) {
        return this.contentDao.delete(contentNo);
    }
}
