package hu.webler.weblercucumberintegration.controller;

import hu.webler.weblercucumberintegration.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
}
