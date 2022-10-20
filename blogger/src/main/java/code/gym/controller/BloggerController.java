package code.gym.controller;

import code.gym.model.Blogger;
import code.gym.service.service.impl.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BloggerController {

    @Autowired
    BloggerService bloggerService;


    @GetMapping("/bloggers")
    public ModelAndView showBlogList() {
        List<Blogger> bloggers = bloggerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogger", bloggers);
        return modelAndView;
    }

    @GetMapping("/blog/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blogger());
        return modelAndView;
    }

    @PostMapping("/blog/create")
    public ModelAndView createBlog(@ModelAttribute("blog") Blogger blogger) {
        bloggerService.save(blogger);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", blogger);
        modelAndView.addObject("message", "Blog created successfully");
        return modelAndView;
    }


    @GetMapping("/edit-blog/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Blogger bloger = bloggerService.findById(id);
        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView update(@ModelAttribute("blog") Blogger blogger) {
        bloggerService.save(blogger);

        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blogger);
        modelAndView.addObject("message", "Updated blog successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Blogger bloger = bloggerService.findById(id);

        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute("blog") Blogger blogger) {
        bloggerService.remove(blogger);
        return "redirect:bloggers";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView view(@PathVariable int id) {
        Blogger bloger = bloggerService.findById(id);

        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/view");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/find")
    public ModelAndView find(@RequestParam String SearchName){
        List<Blogger> bloggers = bloggerService.findBloggerByName(SearchName);
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("bloggers",bloggers);
        return modelAndView;
    }
}
