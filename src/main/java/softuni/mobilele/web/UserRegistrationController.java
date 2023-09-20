package softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import softuni.mobilele.model.dto.UserRegistrationDTO;
import softuni.mobilele.service.UserService;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {

        return "auth-register";
    }


    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDTO) {

        userService.registerUser(userRegistrationDTO);
        return "redirect:/";
    }
}
