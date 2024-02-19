package com.ruoyi.common.rabbitmq.constant;

/**
 * RabbitMQ 默认交换机名称常量
 */
public interface ExchangeNames {

    /**
     * 直接交换机 （工作模式）
     */
    String DIRECT_EXCHANGE = "direct.exchange.default";

    /**
     * 扇出交换机 （发布订阅模式）
     */
    String FANOUT_EXCHANGE = "fanout.exchange.default";

    /**
     * 主题交换机 （直接模式，扇出模式）
     */
    String TOPIC_EXCHANGE = "topic.exchange.default";

    /**
     * 延迟交换机
     */
    String DELAYED_EXCHANGE = "delayed.exchange.default";

    /**
     * 死信交换机
     */
    String DEAD_LETTER_EXCHANGE = "dead-letter.exchange.default";
}
