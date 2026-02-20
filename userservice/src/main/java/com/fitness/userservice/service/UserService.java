package com.fitness.userservice.service;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponseDTO;
import com.fitness.userservice.models.User;
import com.fitness.userservice.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private final PasswordEncoder BCryptPasswordEncoder;

    public UserResponseDTO register(RegisterRequest req){

        if(userRepository.findByEmail(req.getEmail()).isPresent()){
            throw new RuntimeException("User already exists");
        }
          User user = new User();
          user.setEmail(req.getEmail());
          user.setPassword(BCryptPasswordEncoder.encode(req.getPassword()));
          user.setFirstname(req.getFirstName());
          user.setLastname(req.getLastName());
          return new UserResponseDTO(userRepository.save(user));


    }
}
