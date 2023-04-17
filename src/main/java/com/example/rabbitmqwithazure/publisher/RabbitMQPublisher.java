package com.example.rabbitmqwithazure.publisher;

import com.example.rabbitmqwithazure.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class RabbitMQPublisher {

    @Autowired
    RabbitMQConfig rabbitMQConfig;

    @PostMapping(value = "/publish")
    public @ResponseBody String publish(
        @RequestParam("textToSend") String textToSend) {
        try {
            Channel channel = rabbitMQConfig.getRabbitMQConnection();
            channel.basicPublish("", rabbitMQConfig.getQueue(), null,
                textToSend.getBytes(StandardCharsets.UTF_8));
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Message " + textToSend + " sent to the RabbitMQ in AWS Successfully\n Queue  - "
            + rabbitMQConfig.getQueue();
    }

    @GetMapping(value = "/")
    public @ResponseBody String welcome() {
        return "Welcome to Azure Spring App with RabbitMQ integration";
    }

}
