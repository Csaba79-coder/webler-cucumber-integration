package hu.webler.weblercucumberintegration.controller;

import hu.webler.weblercucumberintegration.model.UserRegistrationRequest;
import hu.webler.weblercucumberintegration.model.UserRegistrationResponse;
import hu.webler.weblercucumberintegration.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.status(201).body(userService.saveUser(request));
    }
}