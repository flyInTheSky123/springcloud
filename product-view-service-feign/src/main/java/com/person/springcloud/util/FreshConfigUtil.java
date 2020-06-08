package com.person.springcloud.util;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

//这个地址的作用就是让 config-server 去 git 获取最新的配置信息，并把此信息广播给集群里的两个 视图微服务
public class FreshConfigUtil {

    public static void main(String[] args) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json;charset=utf-8");

        System.out.println("在进行git获取 和 configserver刷新操作时，会等待几秒");

        String result = HttpUtil.createPost("http://localhost:8012/actuator/bus-refresh").addHeaders(headers).execute().body();
        System.out.println("result:"+result);
        System.out.println("refresh");

    }

}
