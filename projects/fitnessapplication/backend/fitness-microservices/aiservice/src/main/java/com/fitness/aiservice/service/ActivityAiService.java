package com.fitness.aiservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitness.aiservice.model.Activity;
import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.model.Recommendation.RecommendationBuilder;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ActivityAiService {
	private final GeminiService geminiService;
	
	public Recommendation generateRecommendation(Activity activity) {
		String prompt=creatPromptForActivity(activity);
		String aiResponse=geminiService.getRecommendations(prompt);
		//log.info("Response from AI {}",aiResponse);
		return processAiResponse(activity,aiResponse);
	}

	private Recommendation processAiResponse(Activity activity, String aiResponse) {
		try {
			ObjectMapper mapper =new ObjectMapper();
			JsonNode rootNode=mapper.readTree(aiResponse);
			JsonNode textNode=rootNode.path("candidates")
					.get(0)
					.path("content")
					.get("parts")
					.get(0)
					.path("text");
			String jsonContent=textNode.asText()
					.replaceAll("\\n```", "")
					.replaceAll("``json\\n", "")
					.replaceAll("```", "")
		            .replaceAll("`", "")
					.trim();
			log.info("Response from AI from clean content {}",jsonContent);
			
			JsonNode analysisJson=mapper.readTree(jsonContent);
			JsonNode analysisNode =analysisJson.path("analysis");
			StringBuilder fullAnalysis=new StringBuilder();
			addAnalysisSection(fullAnalysis,analysisNode,"overall","Overall:");
			addAnalysisSection(fullAnalysis,analysisNode,"pace","Pace:");
			addAnalysisSection(fullAnalysis,analysisNode,"heartRate","Heart Rate:");
			addAnalysisSection(fullAnalysis,analysisNode,"caloriesBurned","Calories :");
			
			List<String>improvements=extractImprovements(analysisJson.path("improvements"));
			List<String>suggestions=extractSuggestions(analysisJson.path("suggestions"));
			List<String>safety=extractSafety(analysisJson.path("safety"));
			
			return Recommendation.builder()
					.activityId(activity.getId())
					.userId(activity.getUserId())
					.type(activity.getType())
					.recommendation(fullAnalysis.toString().trim())
					.improvements(improvements)
					.suggestions(suggestions)
					.safety(safety)
					.createdAt(LocalDateTime.now())
			        
					.build();
			
		}catch(Exception e) {
			e.printStackTrace();
		     return createDefaultRecommendation(activity);
		}
		
	}

	private Recommendation createDefaultRecommendation(Activity activity) {
		
		return Recommendation.builder()
				.activityId(activity.getId())
				.userId(activity.getUserId())
				.type(activity.getType())
				.recommendation("Unable to generate detailed analysis")
				.improvements(Collections.singletonList("Continue with your currant routine"))
				.suggestions(Collections.singletonList("Continue with your currant routine"))
				.safety(Arrays.asList(
						"Always warm up before exercise",
						"Stay hydrated",
						"Listen to your body"
						))
				.createdAt(LocalDateTime.now())
		        
				.build();
	}

	private List<String> extractSafety(JsonNode safetyNode) {
		List<String>safety=new ArrayList();
		if(safetyNode.isArray()) {
			safetyNode.forEach(item->safety.add(item.asText()));
		}
		return safety.isEmpty()?
				Collections.singletonList("follow general guidline"):
					safety;
	}

	private List<String> extractSuggestions(JsonNode suggestionNode) {
		List<String>suggestions=new ArrayList();
		if(suggestionNode.isArray()) {
			suggestionNode.forEach(suggestion->{
				String workout = suggestion.path("workout").asText();
				String description = suggestion.path("description").asText();
				suggestions.add(String.format("%s : %s",workout,description));
			});
		}
		return suggestions.isEmpty()?
				Collections.singletonList("No Specific suggestions  provided"):
					suggestions;
	}

	private List<String> extractImprovements(JsonNode improvementsNode) {
		List<String>improvements=new ArrayList();
		if(improvementsNode.isArray()) {
			improvementsNode.forEach(improvement->{
				String area = improvement.path("area").asText();
				String details = improvement.path("recommendation").asText();
				improvements.add(String.format("%s : %s",area,details));
			});
		}
		return improvements.isEmpty()?
				Collections.singletonList("No Specific Improvements  provide"):
					improvements;
	}

	private void addAnalysisSection(StringBuilder fullAnalysis, JsonNode analysisNode, String key, String prefix) {
		if(!analysisNode.path(key).isMissingNode()) {
			fullAnalysis.append(prefix)
			            .append(analysisNode.path(key).asText())
			            .append("\n\n");
		}
		
	}

	private String creatPromptForActivity(Activity activity) {
		
		return String.format("""
		Analyze this fitness activity and provide  detailed recommendations in the following EXACT JSON fromat:
		{
		   "analysis": {
		       "overall": "Overall analysis here",
		       "pace": "pace analysis here",
		       "heartRate": "Heart rate analysis here",
		       "caloriesBurned": "Calories analysis here"
		   },
		   "improvements": [
		      {
		          "area": "Area name",
		          "recommendation": "Detailed recommendation"
		      }
		   ],
		   "suggestions": [
		      {
		         "workout": "Workout name",
		         "description": "Detailed workout description"
		      }
		   ],
		   "safety": [
		     "Safety point 1",
		     "Safety point 2"
		   
		   ]
		} 
		Analyze this activity:
		Activity Type: %s
		Duration: %d minutes
		calories Burned: %d
		Additional Metrics: %s
		
		Provide detailed  analysis focusingon performance , improvements, next workout suggestions, and safety guidelines.
		Ensure the response follows the EXACT JSON format  shown above. 
		""",
		
				activity.getType(),
				activity.getDuration(),
				activity.getCaloriesBurned(),
				activity.getAdditionalMatrics()
				);
	}

}
