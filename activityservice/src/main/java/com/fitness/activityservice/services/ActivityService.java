package com.fitness.activityservice.services;

import com.fitness.activityservice.config.WebClientConfig;
import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponseDTO;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repos.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final WebClient userServiceWebClient;
    public ActivityResponseDTO track(ActivityRequest request) {
        if(checkUserExists(request.getUserId())) {
            Activity activity = Activity.builder()
                    .userId(request.getUserId())
                    .type(request.getActivityType())
                    .duration(request.getDuration())
                    .caloriesBurned(request.getCaloriesBurned())
                    .startTime(request.getStartTime())
                    .additionalMetrics(request.getAdditionalMetrics())
                    .build();
            Activity savedactivity = activityRepository.save(activity);
            return new ActivityResponseDTO(savedactivity);
        }else{
            throw new RuntimeException("User not found");
        }
    }
    private Boolean checkUserExists(String userId){
        try{
            return userServiceWebClient.get()
                    .uri("/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        }catch (WebClientResponseException.NotFound ex){
            return false;
        }catch (Exception e){
            throw new RuntimeException("Error validating user: " + e.getMessage());
        }
    }
}
