package com.zhanghj.dubbo;

/**
 * 使用dubbo自带的容器启动服务
 * Created by 张汉江 on 2018/12/16
 */
public class Main {
    public static void main(String[] args) {
        com.alibaba.dubbo.container.Main.main(new String[]{"spring","log4j"});
    }

}
