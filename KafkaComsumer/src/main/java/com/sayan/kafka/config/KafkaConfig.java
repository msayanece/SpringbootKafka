package com.sayan.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.sayan.kafka.models.SimpleDataModel;

@Configuration
@EnableKafka
public class KafkaConfig {

	@Value("${kafka.boot.server}")
	private String kafkaServer;
	
	@Value("${kafka.consumer.group.id}")
	private String kafkaGroupId;
	
	@Bean
	public ConsumerFactory<String, SimpleDataModel> getConsumerFactory(){
		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaGroupId);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(SimpleDataModel.class));
	}
	
	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, SimpleDataModel>> getKafkaListener(){
		ConcurrentKafkaListenerContainerFactory<String, SimpleDataModel> listener = new ConcurrentKafkaListenerContainerFactory<>();
		listener.setConsumerFactory(getConsumerFactory());
		return listener;
	}
}
