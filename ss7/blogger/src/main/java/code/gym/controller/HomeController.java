package code.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage(){
        return "blog/home";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "blog/myLogin";
    }
}
