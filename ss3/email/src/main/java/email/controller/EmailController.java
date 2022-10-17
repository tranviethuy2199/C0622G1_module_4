package email.controller;

import email.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {


    @GetMapping("/showPage")
    public String showPage(Model model){
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);

        model.addAttribute("email", new Email());
        model.addAttribute("pageSize" , pageSize);
        model.addAttribute("email" , new Email());
        model.addAttribute("languageList" , languageList);

        return "/index";
    }

}
