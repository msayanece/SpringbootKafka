package com.sayan.kafka.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.sayan.kafka.models.SimpleDataModel;

@Service
public class KafkaProducerService {
	
	@Autowired
	KafkaTemplate<String, SimpleDataModel> kafkaTemplate;
	
	@Value("${kafka.topic.name}")
	private String topicName;

	public String publish(String data) {
		//create a simple data model
		SimpleDataModel model = new SimpleDataModel("Producer", "Sayan", data, "Sample remarks.");
		
		//create headers, put topic name
		Map<String, Object> kafkaHeaders = new HashMap<>();
		kafkaHeaders.put(KafkaHeaders.TOPIC, topicName);
		
		//send
		kafkaTemplate.send(new GenericMessage<SimpleDataModel>(model, kafkaHeaders));
		
		return "Data published successfully.";
	}

}
