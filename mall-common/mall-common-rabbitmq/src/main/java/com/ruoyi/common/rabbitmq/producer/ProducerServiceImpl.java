package com.ruoyi.common.rabbitmq.producer;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.ruoyi.common.rabbitmq.constant.ExchangeNames;
import com.ruoyi.common.rabbitmq.constant.RoutingKeyNames;
import com.ruoyi.common.rabbitmq.exception.RabbitMessageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息生产者服务实现类
 */
@Slf4j
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 直接交换模式
     * <p>
     * 发送消息, 简单路由匹配
     *
     * @param message 消息体
     */
    @Override
    public void send(Object message) {
        send(RoutingKeyNames.DIRECT_ROUTING_KEY, message);
    }

    /**
     * 直接交换模式
     * <p>
     * 发送消息, 简单路由匹配
     *
     * @param routingKey 路由key
     * @param message    消息体
     */
    @Override
    public void send(String routingKey, Object message) {
        send(ExchangeNames.DIRECT_EXCHANGE, routingKey, message);
    }

    /**
     * 直接交换模式
     * <p>
     * 发送消息, 简单路由匹配
     *
     * @param exchangeName 交换机名称
     * @param routingKey   路由key
     * @param message      消息体
     */
    @Override
    public void send(String exchangeName, String routingKey, Object message) throws RabbitMessageException {
        String uuid = IdUtil.fastSimpleUUID();
        CorrelationData correlationData = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message, processor -> {
            processor.getMessageProperties().setMessageId(uuid);
            return processor;
        }, correlationData);
    }

    /**
     * 广播模式
     * <p>
     * 发布消息, 发布订阅
     *
     * @param message 消息体
     */
    @Override
    public void publish(Object message) {
        publish(ExchangeNames.FANOUT_EXCHANGE, message);
    }

    /**
     * 广播模式
     * <p>
     * 发布消息, 发布订阅
     *
     * @param exchangeName 交换机名称
     * @param message      消息体
     */
    @Override
    public void publish(String exchangeName, Object message) throws RabbitMessageException {
        String uuid = IdUtil.fastSimpleUUID();
        CorrelationData correlationData = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(exchangeName, RoutingKeyNames.FANOUT_ROUTING_KEY, message, processor -> {
            processor.getMessageProperties().setMessageId(uuid);
            return processor;
        }, correlationData);
    }

    /**
     * 主题模式 (包含直接交换模式, 广播模式)
     * <p>
     * 发送消息, 复杂路由匹配
     *
     * @param message 消息体
     */
    @Override
    public void topic(Object message) {
        topic(RoutingKeyNames.TOPIC_ROUTING_KEY, message);
    }

    /**
     * 主题模式 (包含直接交换模式, 广播模式)
     * <p>
     * 发送消息, 复杂路由匹配
     *
     * @param routingKey 路由key
     * @param message    消息体
     */
    @Override
    public void topic(String routingKey, Object message) {
        topic(ExchangeNames.TOPIC_EXCHANGE, routingKey, message);
    }

    @Override
    public void topic(String exchangeName, String routingKey, Object message) throws RabbitMessageException {
        String uuid = IdUtil.fastSimpleUUID();
        CorrelationData correlationData = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message, processor -> {
            processor.getMessageProperties().setMessageId(uuid);
            return processor;
        }, correlationData);
    }

    /**
     * 延迟消息
     *
     * @param message   消息体
     * @param delayTime 延迟时长 单位/毫秒 延迟极限是 2^32-1=4294967296 毫秒
     */
    @Override
    public void delay(Object message, Integer delayTime) {
        delay(RoutingKeyNames.DELAYED_ROUTING_KEY, message, delayTime);
    }

    /**
     * 直接交换模式
     * <p>
     * 延迟消息, 延迟插件, 简单路由匹配
     *
     * @param routingKey 路由key
     * @param message    消息体
     * @param delayTime  延迟时长 单位/毫秒 延迟极限是 2^32-1=4294967296 毫秒
     */
    @Override
    public void delay(String routingKey, Object message, Integer delayTime) {
        delay(RoutingKeyNames.DELAYED_ROUTING_KEY, routingKey, message, delayTime);
    }

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
    @Override
    public void delay(String exchangeName, String routingKey, Object message, Integer delayTime) throws RabbitMessageException {
        String uuid = IdUtil.fastSimpleUUID();
        CorrelationData correlationData = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message, processor -> {
            processor.getMessageProperties().setDelay(delayTime);
            processor.getMessageProperties().setMessageId(uuid);
            return processor;
        }, correlationData);
        log.info("当前时间：{}，发送 {} 毫秒的延迟消息：{}", DateUtil.now(), delayTime, message);
    }
}
