package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 邓仁波
 * @date 2018-10-28
 * 接受mq消息
 */
@Slf4j
@Component
public class MqReceiver {
    //    队列名称为myQueue
    @RabbitListener(queues = "myQueue")
    public void process(String message) {
        log.info("MqReceiver: {}", message);
    }
}
