package com.ruoyi.common.rabbitmq.config;

import com.ruoyi.common.rabbitmq.constant.ExchangeNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * RabbitMQ 发送消息到交换机 消息确认、消息回退 回调实现类。
 */
@Slf4j
@Configuration
public class RabbitMqAckConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 由于 ConfirmCallback, ReturnsCallback接口 是 RabbitTemplate 的内部接口，故需要注入实现类才会生效
     */
    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
        log.info("初始化 RabbitMQ 配置");
    }

    /**
     * 交换机消息确认回调
     *
     * @param correlationData 保存回调消息的ID及相关信息
     * @param ack             交换机是否接收到消息，ack=true为正常，ack=false为失败
     * @param cause           交换机接收消息失败原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String id = correlationData != null ? correlationData.getId() : "";
        if (ack) {
            log.info("交换机已经收到ID为：【{}】 的消息", id);
        } else {
            // 记录日志
            log.error("交换机未收到ID为：【{}】的消息，原因：【{}】 ", id, cause);
        }
    }

    /**
     * 交换机消息回退回调
     *
     * @param returned 回退的消息和元数据
     */
    @Override
    public void returnedMessage(ReturnedMessage returned) {
        if (returned.getExchange().equals(ExchangeNames.DELAYED_EXCHANGE)) {
            log.info(">>>>>> 延迟交换机 【returnedMessage】 消息回退回调: 【{}】 <<<<<<", returned.getExchange());
            return;
        }
        // 记录日志
        log.error("消息 【{}】 , 被交换机 【{}】 退回, 退回原因: 【{}】, 路由key: 【{}】",
            new String(returned.getMessage().getBody()), returned.getExchange(),
            returned.getReplyText(), returned.getRoutingKey());
    }
}
