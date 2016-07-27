package com.hellBoard.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hkkang on 2016. 7. 27..
 */
public class Content {
    private static List<Content> list = new ArrayList();

    // List.add가 되었을 때 자동으로 +1 되는 방법은 없을까?
    public static long currentContentNo = 0L;

    private long contentNo;
    private String userId;
    private String subject;
    private String text;
    private LocalDateTime registrationDateTime;
    private long viewCount;

    private Content() {}

    public Content(String userId,
                   String subject,
                   String text,
                   LocalDateTime registrationDateTime) {

        Content.currentContentNo++;
        this.contentNo = Content.currentContentNo;
        this.userId = userId;
        this.subject = subject;
        this.text = text;
        this.registrationDateTime = registrationDateTime;
        this.viewCount = 0L;
    }

    public static List<Content> getInstance() {
        return list;
    }

    public Long getContentNo() {
        return contentNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
}
