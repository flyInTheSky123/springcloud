package com.person.springcloud;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

//断路器监控
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {

    public static void main(String[] args) {

        int port = 8020;
        if (!NetUtil.isUsableLocalPort(port)) {
            System.out.println("该端口%d已经被占用" + port);
            System.exit(1);

        }

        new SpringApplicationBuilder(HystrixDashboardApplication.class).properties("server.port=" + port).run(args);
    }

}
