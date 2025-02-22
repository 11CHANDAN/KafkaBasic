package com.kafka.kafka_tutorial.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Kafka_consumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Kafka_consumer.class);
	
	@KafkaListener(topics = "myTopic" , groupId = "myGroup")
	public void consumer(String message) {
		LOGGER.info("Meesage Received -> {}",message);
	}
}
