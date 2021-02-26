package com.sayan.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class KafkaComsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaComsumerApplication.class, args);
	}

}
