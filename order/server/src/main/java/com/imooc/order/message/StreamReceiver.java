package com.imooc.order.message;

import com.imooc.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * spring cloud stream消息接受
 *
 * @author 邓仁波
 * @date 2018-11-3
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {
//    @StreamListener(StreamClient.INPUT)
//    @SendTo(StreamClient.OUTPUT)
//    public Object processin(String message) {
//        log.info("StreamReceiver: {}", message);
//        return message;
//    }
//
//    @StreamListener(StreamClient.OUTPUT)
//    public void processout(String message) {
//        log.info("StreamReceiver: {}", message);
//    }

//    消息转发
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public Object processin(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
        return message;
    }
//接受
    @StreamListener(StreamClient.OUTPUT)
    public void processout(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
    }

}
