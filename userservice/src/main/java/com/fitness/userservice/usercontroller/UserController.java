package com.fitness.userservice.usercontroller;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponseDTO;
import com.fitness.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterRequest req){

        return ResponseEntity.ok(userService.register(req));
    }
    @GetMapping("{userId}/validate")
    public ResponseEntity<Boolean> validate(@PathVariable("userId") String userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.validateuser(userId));
    }
}
