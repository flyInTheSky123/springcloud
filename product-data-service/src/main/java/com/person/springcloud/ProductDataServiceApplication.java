package com.person.springcloud;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import com.sun.corba.se.impl.logging.InterceptorsSystemException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/*
Future:
提供了方法来检查是否计算已经完成，还是正在计算而处于等待状态，并且也提供了获取计算结果 方法。
当计算完成后，只能通过get方法来获取执行结果，必要的话该方法会阻塞。通过cancel方法可以取消计算。一旦计算已经完成，便无法取消。

 主要方法：

cancel()：取消任务

get()：等待任务执行完成，并获取执行结果

get(long timeout, TimeUnit unit)：在指定的时间内会等待任务执行，超时则抛异常。
 */

/*
这里主要是为了进行微服务注册
 */
@SpringBootApplication
@EnableEurekaClient
public class ProductDataServiceApplication {

    public static void main(String[] args) {

        int port;
        int defaultPort = 8001;
        //异步处理
        Future<Integer> future = ThreadUtil.execAsync(() -> {
            int p = 0;
            System.out.println("请于5秒钟内输入端口号, 推荐  8001 、 8002  或者  8003，超过5秒将默认使用 " + defaultPort);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String s = scanner.nextLine();

                if (!NumberUtil.isInteger(s)) {
                    System.err.printf("请输入数字");
                    continue;

                } else {
                    //使用它将参数转换为int 类型的好处是：当参数为null时，会返回0，而不会报异常
                    p = Convert.toInt(s);
                    scanner.close();
                    break;

                }
            }
            return p;

        });

        try{
            //get(long timeout, TimeUnit unit)：在指定的时间内会等待任务执行，超时则抛异常。
            port = future.get(5, TimeUnit.SECONDS);
        }catch (InterruptedException | TimeoutException | ExecutionException e){
            port=defaultPort;

        }


        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }

        new SpringApplicationBuilder(ProductDataServiceApplication.class).properties("server.port=" + port).run(args);
    }




}
