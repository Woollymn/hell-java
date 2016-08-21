package com.hell_board.config.exception;

public class IdPasswordNoMatchingException extends RuntimeException {
    public IdPasswordNoMatchingException(String message) {
        super(message);
    }
}