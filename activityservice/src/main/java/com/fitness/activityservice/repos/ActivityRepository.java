package com.fitness.activityservice.repos;

import com.fitness.activityservice.dto.ActivityResponseDTO;
import com.fitness.activityservice.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,String> {
}
