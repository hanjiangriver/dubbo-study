package com.zhanghj.dubbo.spi.impl;

import com.zhanghj.dubbo.spi.DataSource;

/**
 * Created by 张汉江 on 2018/12/17
 */
public class MysqlDataSource implements DataSource {
    public void connect(String str) {
        System.out.println(" mysql :"+str);
    }
}
