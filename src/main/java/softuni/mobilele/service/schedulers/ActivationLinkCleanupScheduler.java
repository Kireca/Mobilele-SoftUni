package softuni.mobilele.service.schedulers;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import softuni.mobilele.service.UserActivationService;

import java.time.LocalDateTime;

@Component
public class ActivationLinkCleanupScheduler {


    private final UserActivationService userActivationService;

    public ActivationLinkCleanupScheduler(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void cleanUp() {
        System.out.println("Trigger cleanup of activation links." + LocalDateTime.now());
        userActivationService.cleanUpObsoleteActivationLinks();
    }
}
