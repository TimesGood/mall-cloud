package com.mall.core.exception;


import com.mall.core.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 */
public class Asserts {
    public static void fail(String message) {
        throw new ServiceException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ServiceException(errorCode);
    }
}
