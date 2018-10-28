package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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
    //    1.队列名称为myQueue 需要手动去mq创建队列
//    @RabbitListener(queues = "myQueue")

    //    2.自动创建mq队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))

    //    3.自动创建，Exchange和Queue自动绑定
    @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"), exchange = @Exchange("myExchange")))
    public void process(String message) {
        log.info("MqReceiver: {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("computerOrder"), key = "computer"
            , exchange = @Exchange("myOrder")))
    public void processComputer(String message) {
        log.info("computer MqReceiver: {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("fruitOrder"), key = "fruit"
            , exchange = @Exchange("myOrder")))
    public void processFruit(String message) {
        log.info("fruit MqReceiver: {}", message);
    }
}
