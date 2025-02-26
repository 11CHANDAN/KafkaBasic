package com.kafka.kafka_tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.kafka_tutorial.model.User;
import com.kafka.kafka_tutorial.producer.Kafka_Producer;

@RestController
public class Kafka_Controller {
	
	@Autowired
	private Kafka_Producer producer;
	
	@GetMapping("/kafka/publish")
	public ResponseEntity<String> publishMsg(@RequestParam String message){
		producer.sendMessage(message);
		return ResponseEntity.ok("Message successfully published to consumer");
	}
	
	@PostMapping("/kafka/user")
	public ResponseEntity<User> publishUser(@RequestBody User user){
		producer.sendJsonMessage(user);
		return new ResponseEntity<User>(user , HttpStatus.OK);
		
	}
}
