package softuni.mobilele.service;

import softuni.mobilele.model.dto.UserLoginDTO;
import softuni.mobilele.model.dto.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
}
