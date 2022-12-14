package product.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product.manager.model.Product;
import product.manager.service.IProductService;
import product.manager.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product) {
         productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "/view";
    }

    @GetMapping("/find")
    public String find(@RequestParam String searchName , Model model) {
        List<Product> productList = productService.findProduct(searchName);
        model.addAttribute("products",productList);
        return "/index";
    }

}
