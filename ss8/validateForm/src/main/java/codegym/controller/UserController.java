package codegym.controller;

import codegym.dto.Userdto;
import codegym.model.User;
import codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;


    @GetMapping("")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("users/form");
        modelAndView.addObject("userDto", new Userdto());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView accept(@ModelAttribute @Validated Userdto userdto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("users/form");
            return modelAndView;
        } else {
            User user = new User();
            BeanUtils.copyProperties(userdto, user);
            iUserService.save(user);
            ModelAndView modelAndView = new ModelAndView("users/result");
            return modelAndView;
        }
    }


}
