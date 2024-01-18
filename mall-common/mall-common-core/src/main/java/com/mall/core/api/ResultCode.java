package com.mall.core.api;

import com.mall.core.constant.HttpStatus;

/**
 * 枚举了一些常用API操作码
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(HttpStatus.SUCCESS, "操作成功"),
    ERROR(HttpStatus.ERROR, "操作失败"),
    VALIDATE_FAILED(HttpStatus.NOT_FOUND, "参数检验失败"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "暂未登录或token已经过期"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "没有相关权限");
    private int code;
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return message;
    }
}
