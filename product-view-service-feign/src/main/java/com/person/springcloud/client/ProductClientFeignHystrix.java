package com.person.springcloud.client;


import com.person.springcloud.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//断路器，当@FeignClient(value = "PRODUCT-DATA-SERVICE"，fallback =ProductClientFeignHystrix.class）
// FeignClient感应到注册中心的PRODUCT-DATA-SERVICE关闭或者不工作时，自动使用fallback的类进行备用
@Component
public class ProductClientFeignHystrix implements ProductClientFeign {
    @Override
    public List<Product> listProducts() {

        List<Product> products = new ArrayList<>();
        products.add(new Product(0, "数据微服务已经断开", 0));
        return products;
    }
}
