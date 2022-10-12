package com.example.lab1.constant;

public enum AuthErrorCode {
    MISSING_USERNAME_FIELD(0, "Tên tài khoản là bắt buộc."),
    MISSING_PASSWORD_FIELD(0, "Mật khẩu là bắt buộc."),
    USERNAME_INVALID(0, "Tên tài khoản không hợp lệ, tối thiểu phải có 5 ký tự."),
    PASSWORD_INVALID(0, "Mật khẩu không hợp lệ, phải chứa ít nhất 8 ký tự trong đó có ít nhất 1 chữ in thường, 1 chữ in hoa, 1 số và 1 ký tự đặc biệt."),
    MISSING_OLD_PASSWORD_FIELD(0, "Mật khẩu cũ là bắt buộc."),
    MISSING_NEW_PASSWORD_FIELD(0, "Mật khẩu mới là bắt buộc."),
    OLD_PASSWORD_INVALID(0, "Mật khẩu cũ không hợp lệ."),
    NEW_PASSWORD_INVALID(0, "Mật khẩu mới không hợp lệ, phải chứa ít nhất 8 ký tự trong đó có ít nhất 1 chữ in thường, 1 chữ in hoa, 1 số và 1 ký tự đặc biệt."),
    INTERNAL_ERROR(0, "Có lỗi xảy ra, hãy thử lại sau!"),
    USERNAME_PASSWORD_INVALID(0, "Tài khoản hoặc mật khẩu không đúng, hãy thử lại!");
    private final int code;
    private String message;
    AuthErrorCode(int code, String message) {
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
