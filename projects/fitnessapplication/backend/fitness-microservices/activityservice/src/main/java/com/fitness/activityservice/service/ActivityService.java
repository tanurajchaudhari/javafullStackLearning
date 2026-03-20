package com.fitness.activityservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repo.ActivityRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ActivityService {
	private final ActivityRepository activityRepository;
	private final UserValidationService userValidationService;
	
	private final KafkaTemplate<String,Activity> kafkaTemplate; 
	
	@Value("${kafka.topic.name}")
	private String topicName;

	public  ActivityResponse trackActivity(ActivityRequest request) {
		System.err.println("in traack activity");
		boolean validateUser = userValidationService.validateUser(request.getUserId());
        if(!validateUser) {
        	throw new RuntimeException("Invaliduser for user id is  : "+ request.getUserId());
        }
	     Activity activity  =     Activity.builder()
	          .userId(request.getUserId())
	          .type(request.getType())
	          .duration(request.getDuration()) 
	          .caloriesBurned(request.getCaloriesBurned())
	          .startTime(request.getStartTime())
	          .additionalMatrics(request.getAdditionalMatrics())
	          .build();
	          
	          Activity savedActivity  = activityRepository.save(activity);
	          
	          try {
	        	  kafkaTemplate.send(topicName,savedActivity.getUserId(),savedActivity);
	          }catch(Exception e) {
	        	  e.printStackTrace();
	          }
		
		return mapToResponse(savedActivity);
	}
	private ActivityResponse mapToResponse(Activity activity) {
		ActivityResponse response=new ActivityResponse();
		response.setId(activity.getId());
		response.setUserId(activity.getUserId());
		response.setDuration(activity.getDuration());
		response.setAdditionalMatrics(activity.getAdditionalMatrics());
		response.setCaloriesBurned(activity.getCaloriesBurned());
		response.setType(activity.getType());
		response.setStartTime(activity.getStartTime());
		response.setUpdatedTime(activity.getUpdatedTime());
		response.setCreatedTime(activity.getCreatedTime());
		return response;
	}
}
