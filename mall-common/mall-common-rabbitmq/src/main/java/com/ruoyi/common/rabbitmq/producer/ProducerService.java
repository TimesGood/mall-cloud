package com.ruoyi.common.rabbitmq.producer;

import com.ruoyi.common.rabbitmq.exception.RabbitMessageException;

/**
 * 消息生产者服务
 */
public interface ProducerService {

    /**
     * 直接交换模式
     * <p>
     * 发送消息, 简单路由匹配
     *
     * @param message 消息体
     */
    void send(Object message) throws RabbitMessageException;

    /**
     * 直接交换模式
     * <p>
     * 发送消息, 简单路由匹配
     *
     * @param routingKey 路由key
     * @param message    消息体
     */
    void send(String routingKey, Object message) throws RabbitMessageException;

    /**
     * 发送消息
     *
     * @param exchangeName 交换机名称
     * @param routingKey   路由key
     * @param message      消息体
     */
    void send(String exchangeName, String routingKey, Object message) throws RabbitMessageException;

    /**
     * 广播模式
     * <p>
     * 发布消息, 发布订阅
     *
     * @param message 消息体
     */
    void publish(Object message) throws RabbitMessageException;

    /**
     * 广播模式
     * <p>
     * 发布消息, 发布订阅
     *
     * @param exchangeName 交换机名称
     * @param message      消息体
     */
    void publish(String exchangeName, Object message) throws RabbitMessageException;

    /**
     * 主题模式 (包含直接交换模式, 广播模式)
     * <p>
     * 发送消息, 复杂路由匹配
     *
     * @param message 消息体
     */
    void topic(Object message) throws RabbitMessageException;

    /**
     * 主题模式 (包含直接交换模式, 广播模式)
     * <p>
     * 发送消息, 复杂路由匹配
     *
     * @param routingKey 路由key
     * @param message    消息体
     */
    void topic(String routingKey, Object message) throws RabbitMessageException;

    /**
     * 主题模式 (包含直接交换模式, 广播模式)
     * <p>
     * 发送消息, 复杂路由匹配
     *
     * @param exchangeName 交换机名称
     * @param routingKey   路由key
     * @param message      消息体
     */
    void topic(String exchangeName, String routingKey, Object message) throws RabbitMessageException;

    /**
     * 直接交换模式
     * <p>
     * 延迟消息, 延迟插件
     *
     * @param message   消息体
     * @param delayTime 延迟时长 单位/毫秒 延迟极限是 2^32-1=4294967296 毫秒
     */
    void delay(Object message, Integer delayTime) throws RabbitMessageException;

    /**
     * 直接交换模式
     * <p>
     * 延迟消息, 延迟插件, 简单路由匹配
     *
     * @param routingKey 路由key
     * @param message    消息体
     * @param delayTime  延迟时长 单位/毫秒 延迟极限是 2^32-1=4294967296 毫秒
     */
    void delay(String routingKey, Object message, Integer delayTime) throws RabbitMessageException;

    /**
     * 直接交换模式
     * <p>
     * 延迟消息, 延迟插件, 简单路由匹配
     *
     * @param exchangeName 交换机名称
     * @param routingKey   路由key
     * @param message      消息体
     * @param delayTime    延迟时长 单位/毫秒 延迟极限是 2^32-1=4294967296 毫秒
     */
    void delay(String exchangeName, String routingKey, Object message, Integer delayTime) throws RabbitMessageException;
}
