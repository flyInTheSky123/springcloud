package com.person.springcloud.controller;

import com.person.springcloud.pojo.Product;
import com.person.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object listProducts(){
        List<Product> products = productService.listProducts();

        return products;

    }

}
