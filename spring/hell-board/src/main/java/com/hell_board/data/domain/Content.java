package com.hell_board.data.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Content {
    private static List<Content> list = new ArrayList();

    private long contentNo;
    private String userId;
    private String subject;
    private String text;
    private LocalDateTime registerDateTime;
    private long viewCount;

    public Content() {}

    public Content(long contentNo, String userId, String subject, String text, LocalDateTime registerDateTime, long viewCount) {
        this(userId, subject, text, registerDateTime);
        this.contentNo = contentNo;
        this.viewCount = viewCount;
    }

    public Content(String userId, String subject, String text, LocalDateTime registrationDateTime) {

        this.userId = userId;
        this.subject = subject;
        this.text = text;
        this.registerDateTime = registrationDateTime;
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

    public LocalDateTime getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(LocalDateTime registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
}
