package com.ruoyi.common.rabbitmq.constant;

/**
 * RabbitMQ 默认队列名称常量
 */
public interface QueueNames {

    /**
     * 直接（直连）队列 （路由模式）
     */
    String DIRECT_QUEUE = "direct.queue.default";

    /**
     * 扇出(群发)队列 （发布订阅模式）
     */
    String FANOUT_QUEUE = "fanout.queue.default";

    /**
     * 主题队列 包含（路由模式，发布订阅模式）
     */
    String TOPIC_QUEUE = "topic.queue.default";

    /**
     * 延迟队列
     */
    String DELAYED_QUEUE = "delayed.queue.default";

    /**
     * 死信队列
     */
    String DEAD_LETTER_QUEUE = "dead-letter.queue.default";
}
