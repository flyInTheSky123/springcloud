package com.person.springcloud.util;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;

public class AccessViewService {
    public static void main(String[] args) {

        while (true){

            ThreadUtil.sleep(500);

            try {
                String html = HttpUtil.get("http://localhost:8012/products");
                System.out.println("html length: "+html.length());
            }catch (Exception e){
                System.err.printf(e.getMessage());
            }



        }

    }
}