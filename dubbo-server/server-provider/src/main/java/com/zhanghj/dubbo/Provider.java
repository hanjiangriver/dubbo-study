package com.zhanghj.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by 张汉江 on 2018/12/12
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("META-INF/spring/provider.xml");
        context.start();
        //等待 消费者调用
        System.out.println("-----------服务端启动--------------");
        System.in.read();
    }
}
