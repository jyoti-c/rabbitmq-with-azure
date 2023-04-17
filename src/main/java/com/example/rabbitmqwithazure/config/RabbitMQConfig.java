package com.example.rabbitmqwithazure.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;


@ConfigurationProperties("rabbitmq")
@Service
public class RabbitMQConfig {

    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    private String username;
    private String password;

    private String queue;

    public Channel getRabbitMQConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            factory.setUsername(getUsername());
            factory.setPassword(getPassword());
            factory.setHost(getHost());
            factory.setPort(getPort());
            factory.useSslProtocol();
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            return channel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

