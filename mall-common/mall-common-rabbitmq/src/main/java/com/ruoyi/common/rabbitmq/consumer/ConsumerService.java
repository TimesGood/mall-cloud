package com.ruoyi.common.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

import java.io.IOException;

/**
 * 消息消费者服务
 */
public interface ConsumerService {

    /**
     * 直接交换模式
     * <p>
     * 接收消息
     *
     * @param message 消息体
     * @param channel 信道
     */
//    @RabbitListener(bindings = @QueueBinding(
//        value = @Queue(QueueNames.DIRECT_QUEUE),
//        exchange = @Exchange(ExchangeNames.DIRECT_EXCHANGE),
//        key = RoutingKeyNames.DIRECT_ROUTING_KEY))
    default void receive(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        try {
            // 确认收到消息，false只确认当前一个消息收到，true确认所有consumer获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            if (message.getMessageProperties().getRedelivered()) {
                // 拒绝消息，requeue=false 表示不再重新入队，如果配置了死信队列则进入死信队列
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            } else {
                // ack返回false，requeue-true并重新回到队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }

    /**
     * 发布订阅模式
     * <p>
     * 订阅消息
     *
     * @param message 消息体
     * @param channel 信道
     */
//    @RabbitListener(bindings = @QueueBinding(
//        value = @Queue(QueueNames.FANOUT_QUEUE),
//        exchange = @Exchange(ExchangeNames.FANOUT_EXCHANGE),
//        key = RoutingKeyNames.FANOUT_ROUTING_KEY))
    default void subscribe(Message message, Channel channel) throws IOException {
    }

    /**
     * 主题模式
     * <p>
     * 主题接收消息
     *
     * @param message 消息体
     * @param channel 信道
     */
//    @RabbitListener(bindings = @QueueBinding(
//        value = @Queue(QueueNames.TOPIC_QUEUE),
//        exchange = @Exchange(ExchangeNames.TOPIC_EXCHANGE),
//        key = RoutingKeyNames.TOPIC_ROUTING_KEY))
    default void topicReceive(Message message, Channel channel) throws IOException {
    }

    /**
     * 直接交换模式
     * <p>
     * 延迟消息
     *
     * @param message 消息体
     * @param channel 信道
     */
//    @RabbitListener(bindings = @QueueBinding(
//        value = @Queue(QueueNames.DELAYED_QUEUE),
//        exchange = @Exchange(ExchangeNames.DELAYED_EXCHANGE),
//        key = RoutingKeyNames.DELAYED_ROUTING_KEY))
    default void delayMessage(Message message, Channel channel) throws IOException {
    }
}
