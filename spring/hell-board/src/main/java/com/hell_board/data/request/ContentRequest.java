package com.hell_board.data.request;

import java.time.LocalDateTime;

public class ContentRequest {
    private long contentNo;
    private String email;
    private String subject;
    private String text;
    private LocalDateTime registerDateTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public long getContentNo() {
        return contentNo;
    }

    public void setContentNo(long contentNo) {
        this.contentNo = contentNo;
    }
}
