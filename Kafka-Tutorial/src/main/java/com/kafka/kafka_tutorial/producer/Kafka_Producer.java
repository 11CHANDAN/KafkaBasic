package com.kafka.kafka_tutorial.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.kafka_tutorial.model.User;

@Service
public class Kafka_Producer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Kafka_Producer.class);
	
	public void sendMessage(String message) {
		LOGGER.info(String.format("kafka message %s", message));
		kafkaTemplate.send("myTopic", message);
	}
	
	public void sendJsonMessage(User user) {
		LOGGER.info("start of sendJsonMessage()");
		LOGGER.info("User object {}",user.toString());
		Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "myTopic").build();
		kafkaTemplate.send(message);
		LOGGER.info("Succesfuly sent message to kafka producer");
	}
}
