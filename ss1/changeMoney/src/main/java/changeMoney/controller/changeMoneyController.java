package changeMoney.controller;

import changeMoney.service.IChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class changeMoneyController {

    @Autowired
    IChange iChange;


    @GetMapping("")
    public String View() {
        return "/index";
    }

    @GetMapping("/result")
    public String change(@RequestParam double usd , Model model){
        double vnd = iChange.convert(usd);
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "/index";
    }
}
