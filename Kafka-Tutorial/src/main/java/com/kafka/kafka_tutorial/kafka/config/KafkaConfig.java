package com.kafka.kafka_tutorial.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.retrytopic.RetryTopicConfigurationBuilder;

@Configuration
public class KafkaConfig {
	
	@Bean
	public NewTopic myTpoic() {
		return TopicBuilder.name("myTopic").build();
	}
	
	@Bean
	public NewTopic myTopic_Json() {
		return TopicBuilder.name("myTopic_json").build();
	}

}
