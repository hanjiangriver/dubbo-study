package com.zhanghj.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;
import com.zhanghj.dubbo.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by 张汉江 on 2018/12/12
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("-----------消费端启动--------------");
        //获得服务端的bean
        DemoService demoServcie = null;
        demoServcie = (DemoService) context.getBean("demoService");
        //Thread.sleep(10000);
        String call = demoServcie.sayHello("zhanghj");
        String call123 = demoServcie.sayBye("mic");
        System.out.println(call);
        System.out.println(call123);
       // Protocol myprotocol = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("myProtocal");
        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        //System.out.println("----myprotocal---"+myprotocol.getDefaultPort());
        System.in.read();

    }
}
