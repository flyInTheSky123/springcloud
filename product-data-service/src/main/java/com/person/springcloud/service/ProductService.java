package com.person.springcloud.service;

import com.person.springcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    /*
     *
     * 需要注意的是，这里把 端口号 放进了产品信息里。
     * 这个数据服务会做成集群，那么访问者为了分辨到底是从哪个数据微服务取的数据，
     * 就需要提供个端口号，才能意识到是从不同的微服务得到的数据。
     */
    @Value("${server.port}")
    String port;

    public List<Product> listProducts() {

        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "server port" + port, 50));
        products.add(new Product(2, "server port" + port, 150));
        products.add(new Product(3, "server port" + port, 250));


        return products;
    }

}
