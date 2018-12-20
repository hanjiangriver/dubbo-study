package com.zhanghj.dubbo.service;

/**
 * 服务接口
 * Created by 张汉江 on 2018/12/12
 */
public interface DemoService {
    /**
     *  问候
     * @param name 姓名
     * @return
     */
    String sayHello(String name);

    String sayBye(String name);
}
