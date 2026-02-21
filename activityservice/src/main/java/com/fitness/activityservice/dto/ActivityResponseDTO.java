package com.fitness.activityservice.dto;

import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.model.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data

public class ActivityResponseDTO {
    private String activityId;
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private Map<String,Object> additionalMetrics;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public ActivityResponseDTO(Activity activity) {
        this.activityId = activity.getActivityId();
        this.userId = activity.getUserId();
        this.type = activity.getType();
        this.duration = activity.getDuration();
        this.caloriesBurned = activity.getCaloriesBurned();
        this.startTime = activity.getStartTime();
        this.additionalMetrics = activity.getAdditionalMetrics();
        this.createdAt = activity.getCreatedAt();
        this.updatedAt = activity.getUpdatedAt();

    }

}
