package com.zzping.common.application;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class ComsumerText {
    @RabbitListener(bindings =
    @QueueBinding(value = @Queue(name = "test",durable = "true",declare = "true"), exchange = @Exchange(
            name = "/"
    ))
    )
    public void message(@Payload String message, Channel channel, @Headers Map map) throws IOException {
        System.out.println("收到消息"+message);
        channel.basicAck((long)map.get("amqp_deliveryTag"),false);
    }

    @RabbitListener(bindings =
    @QueueBinding(value = @Queue(name = "errorlogqueue",durable = "true",declare = "true"), exchange = @Exchange(
            name = "topic1"
    ))
    )
    public void message2(@Payload String message, Channel channel, @Headers Map map) throws IOException {
        System.out.println("收到消息"+message);
        channel.basicAck((long)map.get("amqp_deliveryTag"),false);
    }
}
