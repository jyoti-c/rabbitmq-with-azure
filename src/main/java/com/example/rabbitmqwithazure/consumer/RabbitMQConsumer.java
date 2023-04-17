package com.example.rabbitmqwithazure.consumer;

import com.example.rabbitmqwithazure.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RabbitMQConsumer {

    @Autowired
    RabbitMQConfig rabbitMQConfig;

    @GetMapping(value = "/consumer")
    public @ResponseBody String getMessageFromQueue() {
        String message = "";
        try {
            Channel channel = rabbitMQConfig.getRabbitMQConnection();
            GetResponse response = channel.basicGet(rabbitMQConfig.getQueue(), true);
            if (response != null) {
                message = new String(response.getBody(), "UTF-8");
            }
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (message.isEmpty()) {
            return "No messages in Queue " + rabbitMQConfig.getQueue();
        } else {
            return "Message successfully received from RabbitMQ\n" + message;
        }


    }

}
