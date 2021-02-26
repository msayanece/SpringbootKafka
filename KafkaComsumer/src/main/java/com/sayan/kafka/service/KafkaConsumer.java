package com.sayan.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sayan.kafka.models.SimpleDataModel;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}", containerFactory = "getKafkaListener")
	public void listenData(SimpleDataModel data) {
		System.out.println(data);
	}
	
	/*
	 * Using default container factory
	 */
	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
	public void listenData(String data) {
		System.out.println("default: " + data);
	}
}
