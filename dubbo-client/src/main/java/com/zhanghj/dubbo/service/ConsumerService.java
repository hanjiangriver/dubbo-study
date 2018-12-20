package com.zhanghj.dubbo.service;


/**
 * 模拟 mock 服务降级
 * Created by 张汉江 on 2018/12/12
 */

public class ConsumerService implements  DemoService{

    public String sayHello(String s) {
       // ServiceLoader.load("");
        return "sayHello mock:"+s;
    }

    public String sayBye(String s) {
        return "sayBye mock:"+s;
    }
}
