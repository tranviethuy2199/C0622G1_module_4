package com.example.controller;

import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/shop")
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    ProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping
    public ModelAndView showList(Model model,
                                 @CookieValue(value = "idProduct",
                                 defaultValue = "-1")int idProduct) {
        if (idProduct != -1){
            model.addAttribute("historyProduct",
                    iProductService.findById(idProduct).getId());
        }
        return new ModelAndView("/index","productList",iProductService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id, HttpServletResponse response){
        Cookie cookie = new Cookie("idProduct", id +"");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("/detail","product",iProductService.findById(id).getId());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @SessionAttribute("cart")CartDto cart) {
        Product product = iProductService.findById(id);
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.getId(),productDto);
            cart.addProduct(productDto);
        return "redirect:/cart";
    }
}
