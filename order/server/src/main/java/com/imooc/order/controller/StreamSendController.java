package com.imooc.order.controller;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 邓仁波
 * @date 2018-11-3
 */
@RestController
public class StreamSendController {
    @Autowired
    private StreamClient streamClient;


    @GetMapping("/streamSendString")
    public void processString() {
        String message = "new " + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }

    @GetMapping("/streamSendObj")
    public void processObj() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1215");
        orderDTO.setBuyerName("");
        orderDTO.setBuyerPhone("");
        orderDTO.setBuyerAddress("");
        orderDTO.setBuyerOpenid("");
        orderDTO.setOrderAmount(new BigDecimal("0"));
        orderDTO.setOrderStatus(0);
        orderDTO.setPayStatus(0);
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
