package com.javahowtos.rabbitmqdemo.config;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.jms.admin.RMQConnectionFactory;

@Configuration
public class RabbitMqDemoConfig {

	@Bean
	public ConnectionFactory jmsConnectionFactory() {
		RMQConnectionFactory connectionFactory = new RMQConnectionFactory();
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setVirtualHost("/");
		connectionFactory.setHost("localhost");
		connectionFactory.setPort(5672);
		return connectionFactory;
	}
}
