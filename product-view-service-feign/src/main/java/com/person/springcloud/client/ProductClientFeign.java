package com.person.springcloud.client;

import com.person.springcloud.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


//断路器：fallback 当前面的PRODUCT-DATA-SERVICE 微服务关闭时， 就启用后面的ProductClientFeignHystrix.class
@FeignClient(value = "PRODUCT-DATA-SERVICE",fallback =ProductClientFeignHystrix.class )
public interface ProductClientFeign {

    @GetMapping("/products")
    public List<Product> listProducts();

}
