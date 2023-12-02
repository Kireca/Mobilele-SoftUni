package softuni.mobilele.service;

import softuni.mobilele.model.events.UserRegisteredEvent;

public interface UserActivationService {


    void userRegistered(UserRegisteredEvent event);

    void cleanUpObsoleteActivationLinks();
}
