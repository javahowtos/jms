package com.javahowtos.rabbitmqdemo.service;

import java.util.UUID;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

	@Autowired
	ConnectionFactory connectionFactory;

	@Scheduled(fixedRate = 1000)
	public void rpcWithSpringJmsTemplate() throws Exception {
		Connection clientConnection = connectionFactory.createConnection();
		clientConnection.start();
		String messageContent = UUID.randomUUID().toString();
		JmsTemplate tpl = new JmsTemplate(connectionFactory);
		tpl.setReceiveTimeout(2000);
		tpl.send("demoqueue", session -> {
			TextMessage message = session.createTextMessage(messageContent);
			message.setJMSCorrelationID(messageContent);
			return message;
		});
	}
}
