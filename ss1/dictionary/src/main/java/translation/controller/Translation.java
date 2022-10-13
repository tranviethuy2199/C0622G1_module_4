package translation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import translation.model.Word;
import translation.service.IDictionary;

import java.util.List;

@Controller
public class Translation {

    @Autowired
    IDictionary iDictionary;

    @GetMapping("")
    public String View() {
        return "/index";
    }

    @GetMapping("/result")
    public String findWord(@RequestParam String word , Model model){
        String vocabulary = iDictionary.findWord(word);
        model.addAttribute("vocabulary",vocabulary);
        return "/index";
    }

}
