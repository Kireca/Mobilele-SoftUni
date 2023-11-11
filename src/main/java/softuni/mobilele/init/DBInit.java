package softuni.mobilele.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {


    private final String defaultAdminPassword;

    public DBInit(@Value("${mobilele.default.admin.pass}") String defaultAdminPassword) {
        this.defaultAdminPassword = defaultAdminPassword;
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Default admin pass: " + defaultAdminPassword);

        //TODO
    }
}
