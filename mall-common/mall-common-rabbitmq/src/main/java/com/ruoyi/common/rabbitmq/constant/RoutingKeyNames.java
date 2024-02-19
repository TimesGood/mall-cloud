package com.ruoyi.common.rabbitmq.constant;

/**
 * RabbitMQ 默认路由key名称常量
 */
public interface RoutingKeyNames {

    /**
     * 直接路由key
     */
    String DIRECT_ROUTING_KEY = "direct.queue.routingKey.default";

    /**
     * 扇出路由key （发布订阅模式不需要路由key，故为空串）
     */
    String FANOUT_ROUTING_KEY = "";

    /**
     * 主题路由key
     * 匹配规则:
     * （*星号）仅代表一个单词
     * （#井号）代表任意个单词
     */
    String TOPIC_ROUTING_KEY = "topic.queue.routingKey.default.#";

    /**
     * 延迟路由key
     */
    String DELAYED_ROUTING_KEY = "delayed.queue.routingKey.default";

    /**
     * 死信路由key
     */
    String DEAD_LETTER_ROUTING_KEY = "dead-letter.queue.routingKey.default";
}
