package com.zhanghj.dubbo.service.impl;


import com.zhanghj.dubbo.service.DemoService;

/**
 * Created by 张汉江 on 2018/12/12
 */

public class DubboServiceImpl implements DemoService {

    public String sayHello(String name) {
        System.out.println("----消费端调用sayHello------");
        return "hello:"+name;
    }

    public String sayBye(String name) {
        System.out.println("----消费端调用sayBye------");
        return "bye:"+name;
    }
}
