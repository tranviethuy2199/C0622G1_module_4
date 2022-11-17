package com.example.controller;

import com.example.model.OrderProduct;
import com.example.model.Product;
import com.example.model.ProductType;
import com.example.service.IOrderService;
import com.example.service.IProductService;
import com.example.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductTypeService productTypeService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        List<ProductType> productTypes = productTypeService.findAll();
        List<OrderProduct> orderProducts = orderService.findAll();
//        Product productEmpty = new Product();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products", products);
        modelAndView.addObject("productTypes", productTypes);
        modelAndView.addObject("orderProducts", orderProducts);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdate(@PathVariable int id) {
        Product product = productService.findById(id);
        List<ProductType> productTypes = productTypeService.findAll();
        List<OrderProduct> orderProducts = orderService.findAll();
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("product", product);
            modelAndView.addObject("productTypes", productTypes);
            modelAndView.addObject("orderProducts", orderProducts);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("product") Product product){
        productService.save(product);
        List<ProductType> productTypes = productTypeService.findAll();
        List<OrderProduct> orderProducts = orderService.findAll();
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("productTypes", productTypes);
        modelAndView.addObject("orderProducts", orderProducts);
        return modelAndView;
    }

}
