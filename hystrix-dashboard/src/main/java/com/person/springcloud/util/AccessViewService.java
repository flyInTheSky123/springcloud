package com.person.springcloud.util;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;


//每次间隔一定时间 ，去访问视图服务，达到可以自动访问，以便在断路监控器中看到
public class AccessViewService {
    public static void main(String[] args) {

        while (true) {

            ThreadUtil.sleep(500);
            access(8012);
            access(8013);

        }

    }

    public static void access(int port) {
        try {
            String html = HttpUtil.get(String.format("http://localhost:%d/products", port));
            System.out.printf("%d 地址的视图微服务访问成功 ，大小是 %d", port, html.length());
        } catch (Exception e) {
            System.err.printf("%d 地址的视图服务无法访问%n",port);
        }


    }

}
