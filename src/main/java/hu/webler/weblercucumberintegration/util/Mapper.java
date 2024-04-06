package hu.webler.weblercucumberintegration.util;

import hu.webler.weblercucumberintegration.entity.User;
import hu.webler.weblercucumberintegration.model.UserRegistrationRequest;
import hu.webler.weblercucumberintegration.model.UserRegistrationResponse;
import org.modelmapper.ModelMapper;

public class Mapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static User mapUserRegRequestToEntity(UserRegistrationRequest request) {
        User user = new User();
        modelMapper.map(request, user);
        return user;
    }

    public static UserRegistrationResponse mapUserEntityToUserRegResponse(User entity) {
        UserRegistrationResponse response = new UserRegistrationResponse();
        modelMapper.map(entity, response);
        return response;
    }

    private Mapper() {

    }
}
