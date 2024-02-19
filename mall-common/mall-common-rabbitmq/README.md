**生产者**
```java
//在业务中调用ProducerService的方法发送消息
producerService.send(ResourceNames.REFRESH_SMS_CHANNEL_ROUTING_KEY, "修改短信渠道");
```
**消费者**

```java
@Slf4j
@Service
@RequiredArgsConstructor
public class DemoConsumer implements ConsumerService {
    
    @RabbitListener(bindings = @QueueBinding(
        value = @Queue(ResourceNames.REFRESH_SMS_CHANNEL_QUEUE),
        exchange = @Exchange(ExchangeNames.DIRECT_EXCHANGE),
        key = ResourceNames.REFRESH_SMS_CHANNEL_ROUTING_KEY))
    @Override
    public void receive(Message message, Channel channel) throws IOException {
        log.info(">>>>>>---------[receive][收到消息]--------->>>>>>>");
        //收到消息后可在此处理业务
        //...
        // 确认收到消息，false只确认当前一个消息收到，true确认所有consumer获得的消息
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
```
