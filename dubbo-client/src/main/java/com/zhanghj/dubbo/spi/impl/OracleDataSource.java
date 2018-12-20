package com.zhanghj.dubbo.spi.impl;

import com.zhanghj.dubbo.spi.DataSource;

/**
 * Created by 张汉江 on 2018/12/17
 */
public class OracleDataSource implements DataSource {
    public void connect(String str) {
        System.out.println(" oracle "+str);
    }
}
