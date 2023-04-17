# AWS RabbitMQ with Azure
This is a Spring Boot Application written in JAVA. It communicates with AWS RabbitMQ to publish and consume messages from the queue. 

The details of connection are provided in application.properties file.

## **Steps to Run on Local**
1. mvn clean install 
2. mvn spring-boot:run 

* The JVM level was changed from '11' to '17', review the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range) on the wiki for more details.
* The original package name 'com.example.rabbitmq-with-azure' is invalid and this project uses 'com.example.rabbitmqwithazure' instead.

## **How to run on Azure?**
Watch this YouTube video for details
