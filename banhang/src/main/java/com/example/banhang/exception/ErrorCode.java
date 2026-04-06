package com.example.banhang.exception;

public enum ErrorCode {
    INVALID_KEY(1001, "invalid message key"),
    UNCATEGORIZED_EXCEPTION(9999, "uncaterozed_exception"),
    USER_EXITED(1001, "User exited"),
    USERNAME_INVALID(1030, "user name must be at least 3 characters"),
    INVALID_PASSWORD(1004, "user name must be at least 3 characters"),
    USER_NOT_EXITED(1005, "user not exited"),
    UNAUTHENTICATED(1006, "unauthenticated")
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
