package com.person.springcloud;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

// turbine 是Spring提供的一个聚合监控，是在原来断路监控的基础上进行的
@SpringBootApplication
@EnableTurbine
public class TurbineApplication {

	public static void main(String[] args) {

		int port=8021;
		if (!NetUtil.isUsableLocalPort(port)){
			System.out.printf("端口%d被占用",port);
			System.exit(1);

		}
		new SpringApplicationBuilder(TurbineApplication.class).properties("server.port="+port).run(args);

	}

}
