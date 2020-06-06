package com.person.springcloud.service;

import com.person.springcloud.client.ProductClientFeign;
import com.person.springcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductClientFeign productClientFeign;

    public List<Product> listProducts() {
        List<Product> products = productClientFeign.listProducts();
        return products;
    }


}
