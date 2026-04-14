package com.fitness.aiservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fitness.aiservice.model.Activity;
import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.repository.RecommendationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActivityMessageListner {
	
	private final ActivityAiService activityAiService; 
	private final RecommendationRepository recommendationRepository;
	
	@KafkaListener(topics="${kafka.topic.name}", groupId="activity-processor-groups" )
	public void processActivity(Activity activity) {
		log.info("Receive activity for processing: {}",activity.getUserId());
		System.err.println("Receive activity for processing: {}"+activity.getUserId());
		
		Recommendation recommendation = activityAiService.generateRecommendation(activity);
		recommendationRepository.save(recommendation);
		
	}

}
