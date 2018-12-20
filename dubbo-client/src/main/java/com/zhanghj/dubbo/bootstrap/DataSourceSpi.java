package com.zhanghj.dubbo.bootstrap;

import com.zhanghj.dubbo.spi.DataSource;
import org.mortbay.util.Loader;

import java.util.ServiceLoader;


/**
 * 测试spi
 * Created by 张汉江 on 2018/12/17
 */
public class DataSourceSpi {
    public static void main(String[] args) {
       ServiceLoader<DataSource> loaders= ServiceLoader.load(DataSource.class);
       for(DataSource loader:loaders){
           loader.connect(" sql ");
       }
    }
}
