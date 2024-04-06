package hu.webler.weblercucumberintegration.service;

import hu.webler.weblercucumberintegration.controller.exception.UsernameAlreadyExistsException;
import hu.webler.weblercucumberintegration.entity.User;
import hu.webler.weblercucumberintegration.model.UserRegistrationRequest;
import hu.webler.weblercucumberintegration.model.UserRegistrationResponse;
import hu.webler.weblercucumberintegration.persistence.UserRepository;
import hu.webler.weblercucumberintegration.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static hu.webler.weblercucumberintegration.util.Mapper.mapUserEntityToUserRegResponse;
import static hu.webler.weblercucumberintegration.util.Mapper.mapUserRegRequestToEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserRegistrationResponse saveUser(UserRegistrationRequest request) {
        String username = request.getUsername();
        Optional<User> existingUser = userRepository.findUserByUsername(username);

        if (existingUser.isPresent()) {
            String message = String.format("User with username: %s already exists!" , username);
            log.info(message);
            throw new UsernameAlreadyExistsException(message);
        }
        User user = mapUserRegRequestToEntity(request);
        return mapUserEntityToUserRegResponse(userRepository.save(user));
    }
}
