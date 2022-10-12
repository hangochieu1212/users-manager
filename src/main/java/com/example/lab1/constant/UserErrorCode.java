package com.example.lab1.constant;

public enum UserErrorCode {
    MISSING_EMAIL_FIELD(0, "Địa chỉ email là bắt buộc."),
    EMAIL_INVALID(0, "Địa chỉ email không hợp lệ."),
    EMAIL_EXISTED(0, "Địa chỉ email đã được sử dụng."),
    EMAIL_NOT_EXIST(0, "Địa chỉ email không tồn tại."),
    MISSING_USERNAME_FIELD(0, "Người dùng là bắt buộc."),
    USERNAME_INVALID(0, "Người dùng không hợp lệ."),
    USERNAME_EXISTED(0, "Người dùng đã được sử dụng."),
    USER_NOT_EXIST(0, "Người dùng không tồn tại."),
    MISSING_FULLNAME_FIELD(0, "Họ và tên là bắt buộc."),
    FULLNAME_INVALID(0, "Họ và tên không hợp lệ."),
    MISSING_PASSWORD_FIELD(0, "Mật khẩu là bắt buộc."),
    PASSWORD_INVALID(0, "Mật khẩu không hợp lệ."),
    SUCCESS(1, "Success"),
    FAIL(0, "Fail"),
    INTERNAL_ERROR(0, "Có lỗi xảy ra, hãy thử lại sau!");
    private final int code;
    private String message;

    UserErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
