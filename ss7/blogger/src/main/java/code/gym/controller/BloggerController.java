package code.gym.controller;

import code.gym.model.Blogger;
import code.gym.model.Category;
import code.gym.service.IBloggerService;
import code.gym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/bloggers")
public class BloggerController {

    @Autowired
    IBloggerService bloggerService;

    @Autowired
    ICategoryService categoryService;


    @GetMapping("")
    public ModelAndView showBlogList(@PageableDefault(value = 2) Pageable pageable) {
        Page<Blogger> bloggers = bloggerService.findAll(pageable);
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("bloggers", bloggers);
        return modelAndView;
    }

    @GetMapping("/blog/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("blog", new Blogger());
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @PostMapping("/blog/create")
    public ModelAndView createBlog(@ModelAttribute("blog") Blogger blogger) {
        blogger.setCreateDate(new Date(System.currentTimeMillis()));
        bloggerService.save(blogger);
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", blogger);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("message", "Blog created successfully");
        return modelAndView;
    }


    @GetMapping("/edit-blog/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Blogger bloger = bloggerService.findById(id);
        List<Category> categories = categoryService.findAll();
        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", bloger);
            modelAndView.addObject("categories", categories);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView update(@ModelAttribute("blog") Blogger blogger) {
        bloggerService.save(blogger);
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blogger);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("message", "Updated blog successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Blogger bloger = bloggerService.findById(id);
        List<Category> categories = categoryService.findAll();
        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", bloger);
            modelAndView.addObject("categories", categories);
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
    public ModelAndView find(@RequestParam String blogger){
        List<Blogger> bloggers = bloggerService.findBloggerByName(blogger);
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogger",bloggers);
        return modelAndView;
    }

}
