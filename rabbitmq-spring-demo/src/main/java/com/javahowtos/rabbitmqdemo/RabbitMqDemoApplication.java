package com.javahowtos.rabbitmqdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class RabbitMqDemoApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(RabbitMqDemoApplication.class, args);

	}

}
