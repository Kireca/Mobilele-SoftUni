package softuni.mobilele.service.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.mobilele.model.dto.UserRegistrationDTO;
import softuni.mobilele.model.entity.UserEntity;
import softuni.mobilele.model.events.UserRegisteredEvent;
import softuni.mobilele.repository.UserRepository;
import softuni.mobilele.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final ApplicationEventPublisher applicationEventPublisher;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ApplicationEventPublisher applicationEventPublisher) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));

        applicationEventPublisher.publishEvent(new UserRegisteredEvent(
                "UserService",
                userRegistrationDTO.email(),
                userRegistrationDTO.fullName()

        ));
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        return new UserEntity()
                .setActive(false)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));
    }
}
