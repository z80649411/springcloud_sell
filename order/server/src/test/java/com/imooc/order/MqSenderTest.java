package com.imooc.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 邓仁波
 * @date 2018-10-28
 * mq消息发送
 */
@Component
public class MqSenderTest extends OrderApplicationTests {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
//        发送消息第一个参数为队列名称 第二个参数为内容
        amqpTemplate.convertAndSend("myQueue", "now: " + new Date());
    }
    @Test
    public void computerSend() {
        amqpTemplate.convertAndSend("myOrder","computer", "now: " + new Date());
    }
}
