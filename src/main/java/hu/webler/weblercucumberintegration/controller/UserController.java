package hu.webler.weblercucumberintegration.controller;

import hu.webler.weblercucumberintegration.model.UserRegistrationRequest;
import hu.webler.weblercucumberintegration.model.UserRegistrationResponse;
import hu.webler.weblercucumberintegration.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.status(CREATED).body(userService.saveUser(request));
    }
}
