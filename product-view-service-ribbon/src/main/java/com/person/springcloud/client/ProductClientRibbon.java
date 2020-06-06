package com.person.springcloud.client;

import com.person.springcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@Component
public class ProductClientRibbon {
    @Autowired
    RestTemplate restTemplate;


    public List<Product> productRibbon(){

        //http://PRODUCT-DATA-SERVICE/products表示注册服务中心中已经注册的名称/访问地址
        return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products",List.class);

    }

}
