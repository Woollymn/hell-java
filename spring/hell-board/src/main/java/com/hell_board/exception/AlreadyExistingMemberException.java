package com.hell_board.exception;

public class AlreadyExistingMemberException extends RuntimeException {
    public AlreadyExistingMemberException(String message) {
        super(message);
    }
}