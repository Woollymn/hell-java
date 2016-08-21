package com.hell_board.config.exception;

public class AlreadyExistingMemberException extends RuntimeException {
    public AlreadyExistingMemberException(String message) {
        super(message);
    }
}