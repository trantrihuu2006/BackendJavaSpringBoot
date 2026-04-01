package com.example.accdls.exception;

public enum ErrorCode {

    INVALID_KEY(1001, "invalid message key"),
    UNCATEGORIZED_EXCEPTON(9999, "uncaterozed_exception"),
    USER_EXITED(1001, "User exited"),
    USERNAME_INVALID(1030, "user name must be at least 3 characters"),
    INVALID_PASSWORD(1004, "user name must be at least 3 characters"),
    USER_NOT_EXITED(1005, "User not exited")
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
