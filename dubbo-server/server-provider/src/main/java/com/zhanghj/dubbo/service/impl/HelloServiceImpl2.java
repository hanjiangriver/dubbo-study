package com.zhanghj.dubbo.service.impl;

import com.zhanghj.dubbo.service.HelloService;

/**
 * {@link HelloServiceImpl} 的版本升级  主要是测试 version 的作用
 * Created by 张汉江 on 2018/12/16
 */
public class HelloServiceImpl2 implements HelloService {
    public String hello(String msg) {
        return "i am version2"+msg;
    }
}
