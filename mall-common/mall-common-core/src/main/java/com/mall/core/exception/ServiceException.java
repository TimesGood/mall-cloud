package com.mall.core.exception;


import com.mall.core.api.IErrorCode;

/**
 * 自定义API异常
 */
public class ServiceException extends RuntimeException {
    private IErrorCode errorCode;

    public ServiceException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
