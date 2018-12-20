package com.zhanghj.dubbo.service.impl;

import com.zhanghj.dubbo.service.HelloService;

/**
 * Created by 张汉江 on 2018/12/16
 */
public class HelloServiceImpl implements HelloService {
    public String hello(String msg) {
        return "i am "+msg;
    }
}
