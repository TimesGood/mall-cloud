package com.ruoyi.common.rabbitmq.exception;

/**
 * RabbitMQ 消息异常类
 */
public class RabbitMessageException extends RuntimeException {

    private static final long serialVersionUID = -6046979938127327842L;

    public RabbitMessageException() {
        super();
    }

    public RabbitMessageException(String message) {
        super(message);
    }

    public RabbitMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public RabbitMessageException(Throwable cause) {
        super(cause);
    }
}
