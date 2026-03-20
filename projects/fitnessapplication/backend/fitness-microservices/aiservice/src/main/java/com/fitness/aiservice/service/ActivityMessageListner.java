package com.fitness.aiservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fitness.aiservice.model.Activity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActivityMessageListner {
	
	@KafkaListener(topics="${kafka.topic.name}", groupId="activity-processor-groups" )
	public void processActivity(Activity activity) {
		log.info("Receive activity for processing: {}",activity.getUserId());
		System.err.println("Receive activity for processing: {}"+activity.getUserId());
	}

}
