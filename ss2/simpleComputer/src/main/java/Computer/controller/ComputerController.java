package Computer.controller;

import Computer.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputerController {

    @Autowired
    IComputerService iComputerService;

    @GetMapping("")
    public String View() {
        return "/index";
    }

    @GetMapping("/result")
    public String calcula (@RequestParam double a, double b, String submit, Model model) {
        model.addAttribute("a",a);
        model.addAttribute("b",b);
        switch (submit) {
            case "summation":
                double summation = iComputerService.summation(a, b);
                model.addAttribute("result",summation);
                break;
            case "subtraction":
                double subtraction = iComputerService.subtraction(a, b);
                model.addAttribute("result",subtraction);
                break;
            case "multiplication":
                double multiplication = iComputerService.multiplication(a, b);
                model.addAttribute("result",multiplication);
                break;
            case "division":
                double division = iComputerService.division(a, b);
                model.addAttribute("result",division);
                break;
        }
        return "/index";
    }
}
