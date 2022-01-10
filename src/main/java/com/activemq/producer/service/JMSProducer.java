package com.activemq.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.activemq.producer.model.Employee;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class JMSProducer {

	@Autowired
	private final JmsTemplate jmsTemplate;

	@Value("${activemq.topic}")
	private String topic;

	public void sendMessage(Employee message) {
		try {
			jmsTemplate.convertAndSend(topic, message);
			log.info("Message {} sent", message);
		} catch (Exception e) {
			log.error("Recieved Exception during send Message: ", e);
		}
	}

}
