package com.hell_board.exception;

public class IdPasswordNoMatchingException extends RuntimeException {
    public IdPasswordNoMatchingException(String message) {
        super(message);
    }
}