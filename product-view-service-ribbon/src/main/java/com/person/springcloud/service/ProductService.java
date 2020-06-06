package com.person.springcloud.service;


import com.person.springcloud.client.ProductClientRibbon;
import com.person.springcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductClientRibbon productClientRibbon;


    public List<Product> listProducts(){
        List<Product> products = productClientRibbon.productRibbon();
        return products;

    }


}
