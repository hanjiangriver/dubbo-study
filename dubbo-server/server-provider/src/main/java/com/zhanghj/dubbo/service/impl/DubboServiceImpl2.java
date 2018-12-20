package com.zhanghj.dubbo.service.impl;


import com.zhanghj.dubbo.service.DemoService;

/**
 * {@link DubboServiceImpl} 的版本升级  主要是测试 version 的作用
 * Created by 张汉江 on 2018/12/12
 */

public class DubboServiceImpl2 implements DemoService {

    public String sayHello(String name) {
        System.out.println("----消费端调用sayHello------");
        return "hello version2:"+name;
    }

    public String sayBye(String name) {
        System.out.println("----消费端调用sayBye------");
        return "bye:"+name;
    }
}
