package com.ruoyi.common.rabbitmq.config;

import com.ruoyi.common.rabbitmq.constant.ExchangeNames;
import com.ruoyi.common.rabbitmq.constant.QueueNames;
import com.ruoyi.common.rabbitmq.constant.RoutingKeyNames;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * RabbitMQ 配置类，声明默认队列、交换机、路由key，定义生产端和消费端的格式为JSON。
 */
@Configuration
public class RabbitConfiguration implements RabbitListenerConfigurer {

    /**
     * 声明直接队列
     *
     * @return 队列对象
     */
    @Bean
    public Queue directQueue() {
        return QueueBuilder.durable(QueueNames.DIRECT_QUEUE).build();
    }

    /**
     * 声明扇出队列
     *
     * @return 队列对象
     */
    @Bean
    public Queue fanoutQueue() {
        return QueueBuilder.durable(QueueNames.FANOUT_QUEUE).build();
    }

    /**
     * 声明主题队列
     *
     * @return 队列对象
     */
    @Bean
    public Queue topicQueue() {
        return QueueBuilder.durable(QueueNames.TOPIC_QUEUE).build();
    }

    /**
     * 声明死信队列
     *
     * @return 队列对象
     */
    @Bean
    public Queue deadLetterQueue() {
        Map<String, Object> arguments = new HashMap<>(3);
        arguments.put("x-dead-letter-exchange", ExchangeNames.DEAD_LETTER_EXCHANGE);
        arguments.put("x-dead-letter-routing-key", RoutingKeyNames.DEAD_LETTER_ROUTING_KEY);
        return QueueBuilder.durable(QueueNames.DEAD_LETTER_QUEUE).withArguments(arguments).build();
    }

    /**
     * 声明延迟队列
     *
     * @return 队列对象
     */
    @Bean
    public Queue delayedQueue() {
        return QueueBuilder.durable(QueueNames.DELAYED_QUEUE).build();
    }

    /**
     * 声明直接交换机
     *
     * @return 直接交换机
     */
    @Bean
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(ExchangeNames.DIRECT_EXCHANGE).build();
    }

    /**
     * 声明扇出交换机
     *
     * @return 扇出交换机
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange(ExchangeNames.FANOUT_EXCHANGE).build();
    }

    /**
     * 声明主题交换机
     *
     * @return 主题交换机
     */
    @Bean
    public TopicExchange topicExchange() {
        return ExchangeBuilder.topicExchange(ExchangeNames.TOPIC_EXCHANGE).build();
    }

    /**
     * 声明死信交换机
     *
     * @return 直接交换机
     */
    @Bean
    public DirectExchange deadLetterExchange() {
        return ExchangeBuilder.directExchange(ExchangeNames.DEAD_LETTER_EXCHANGE).build();
    }

    /**
     * 声明延迟交换机 - 基于RabbitMQ延迟插件
     *
     * @return 自定义交换机
     */
    @Bean
    public CustomExchange delayedExchange() {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("x-delayed-type", ExchangeTypes.DIRECT);
        /*
          1、交换机名称
          2、交换机类型
          3、是否持久化
          4、是否自动删除
          5、其他参数
         */
        return new CustomExchange(ExchangeNames.DELAYED_EXCHANGE, "x-delayed-message", true, false, arguments);
    }

    /**
     * Qualifier 默认取Bean的方法名
     * <p>
     * 声明绑定关系，直接队列绑定到直接交换机，并定义直接路由key
     *
     * @param directQueue    直接队列Bean
     * @param directExchange 直接交换机Bean
     * @return 绑定对象
     */
    @Bean
    public Binding directQueueBindingDirectExchange(
        @Qualifier("directQueue") Queue directQueue,
        @Qualifier("directExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(RoutingKeyNames.DIRECT_ROUTING_KEY);
    }

    /**
     * Qualifier 默认取Bean的方法名
     * <p>
     * 声明绑定关系，扇出队列绑定到扇出交换机
     *
     * @param fanoutQueue    扇出队列Bean
     * @param fanoutExchange 扇出交换机Bean
     * @return 绑定对象
     */
    @Bean
    public Binding fanoutQueueBindingDirectExchange(
        @Qualifier("fanoutQueue") Queue fanoutQueue,
        @Qualifier("fanoutExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    /**
     * Qualifier 默认取Bean的方法名
     * <p>
     * 声明绑定关系，主题队列绑定到主题交换机，并定义主题路由key
     *
     * @param topicQueue    主题队列Bean
     * @param topicExchange 主题交换机Bean
     * @return 绑定对象
     */
    @Bean
    public Binding topicQueueBindingDirectExchange(
        @Qualifier("topicQueue") Queue topicQueue,
        @Qualifier("topicExchange") TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(RoutingKeyNames.TOPIC_ROUTING_KEY);
    }

    /**
     * Qualifier 默认取Bean的方法名
     * <p>
     * 声明绑定关系，死信队列绑定到死信交换机，并定义死信路由key
     *
     * @param deadLetterQueue    死信队列Bean
     * @param deadLetterExchange 死信交换机Bean
     * @return 绑定对象
     */
    @Bean
    public Binding deadLetterQueueBindingDeadLetterExchange(
        @Qualifier("deadLetterQueue") Queue deadLetterQueue,
        @Qualifier("deadLetterExchange") DirectExchange deadLetterExchange) {
        return BindingBuilder.bind(deadLetterQueue).to(deadLetterExchange).with(RoutingKeyNames.DEAD_LETTER_ROUTING_KEY);
    }

    /**
     * Qualifier 默认取Bean的方法名
     * <p>
     * 声明绑定关系，延迟队列绑定到延迟交换机，并定义延迟路由key
     *
     * @param delayedQueue    延迟队列Bean
     * @param delayedExchange 延迟交换机Bean
     * @return 绑定对象
     */
    @Bean
    public Binding delayedQueueBindingDelayedExchange(
        @Qualifier("delayedQueue") Queue delayedQueue,
        @Qualifier("delayedExchange") CustomExchange delayedExchange) {
        return BindingBuilder.bind(delayedQueue).to(delayedExchange).with(RoutingKeyNames.DELAYED_ROUTING_KEY).noargs();
    }

    /**
     * 发送端定义支持 json 的RabbitTemplate
     *
     * @param connectionFactory 连接工厂
     * @return RabbitTemplate
     */
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate template = new RabbitTemplate(connectionFactory);
        // 重写发送端 json 格式的消息转换器，替换默认的SimpleMessageConverter
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

    /**
     * 接收端定义支持 json MessageHandlerMethodFactory
     *
     * @param registrar the registrar to be configured
     */
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }

    /**
     * 消息处理方法工厂
     *
     * @return 消息处理方法工厂
     */
    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        messageHandlerMethodFactory.setMessageConverter(new MappingJackson2MessageConverter());
        return messageHandlerMethodFactory;
    }

}
