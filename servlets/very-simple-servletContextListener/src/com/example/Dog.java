package com.example;

import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by wollymn on 16. 7. 22.
 */
public class Dog {
    private String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void valueBound(HttpSessionBindingEvent event) {
        // 세션에 추가되었을 때 실행될 코드
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        // 세션에서 제거되었을 때 실행될 코드
    }
}