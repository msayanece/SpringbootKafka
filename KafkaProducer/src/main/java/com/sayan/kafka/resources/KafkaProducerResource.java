package com.sayan.kafka.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.kafka.services.KafkaProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerResource {
	
	@Autowired
	private KafkaProducerService kafkaProducerService;

	@GetMapping("/publish/{data}")
	public String publishData(@PathVariable("data") String data) {
		return kafkaProducerService.publish(data);
	}
}
