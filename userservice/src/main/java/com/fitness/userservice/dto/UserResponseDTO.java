package com.fitness.userservice.dto;

import com.fitness.userservice.models.User;
import com.fitness.userservice.models.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
      private String id;
      private String email;
      private String firstname;
      private String lastname;
      private LocalDateTime createdAt;
      private LocalDateTime updatedAt;
      private UserRole role;

      public UserResponseDTO(User user) {
          this.id = user.getId();
          this.email = user.getEmail();
          this.firstname = user.getFirstname();
          this.lastname = user.getLastname();
          this.createdAt = user.getCreatedAt();
          this.updatedAt = user.getUpdatedAt();
          this.role = user.getRole();
      }
}
