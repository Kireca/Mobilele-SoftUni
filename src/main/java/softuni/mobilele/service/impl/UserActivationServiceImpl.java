package softuni.mobilele.service.impl;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import softuni.mobilele.model.events.UserRegisteredEvent;
import softuni.mobilele.service.EmailService;
import softuni.mobilele.service.UserActivationService;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private final EmailService emailService;

    public UserActivationServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }


    @Override
    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {

        //TODO: ADD Activation links.
        emailService.sendRegistrationEmail(event.getUserEmail(), event.getUserNames());
    }
}
