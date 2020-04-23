package com.gajarla.kafka.producer.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gajarla.kafka.producer.app.domain.User;

@RestController
public class AppController {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "test_topic";
	
	@GetMapping("/publish/{name}")
	public String postName(@PathVariable("name") final String name) {
		
		kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));
		
		return "Success";
	}
	
}
