package com.person.springcloud.controller;

import com.person.springcloud.pojo.Product;
import com.person.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object product(Model model){
        List<Product> products = productService.listProducts();
        model.addAttribute("ps",products);
        return model;
    }


}
