# Dubbo笔记

### 1.分布式架构演进过程

|    架构名称    |                           主要特点                           |
| :------------: | :----------------------------------------------------------: |
|  单一应用架构  | 此时所有的业务全部在一个系统里面  我们现在的架构就是这样的架构 |
|    垂直拆分    | 随着业务越来越多  一个系统难以维护  拆分成多个业务无关的垂直应用  分别部署 |
| 分布式服务架构 | 垂直拆分以后 各个服务之间的调用不可避免 需要把关键业务单独出来以供调用 |
|      SOA       |                   此时服务治理 调度很关键                    |

### 2.Dubbo 开发的基本需求

1. 能够进行RPC 调用 完成通信
2. 通信就需要地址  当服务节点过多时 地址的管理就变得异常复杂和繁琐  这时需要一个注册中心完成服务的动态注册以及服务发现
3. 当调用量越来越大  这个时候就需要加机器  加多少  什么时候加 就需要一个指标来确定  这个时候服务治理很重要



### 3.Dubbo 架构

![1544582734412](C:\Users\ADMINI~1\AppData\Local\Temp\1544582734412.png)



- **要特别注意线的颜色 同步 异步  以及初始化**

### 4.Dubbo 具有的特点

1. 连通性   
   - 注册中心、消费者、服务提供者 他们三者之间是长连接的  当提供者挂了以后 注册中心能够立马感知到 并通知消费者（**注册中心能够感知提供者的存在**）
   - 注册中心和监视器都宕机以后  不会影响 消费者和提供者之间的调用   消费者在本地缓存了提供者的列表
   - 注册中心和监控器都是可选的 消费者可以直连提供者
2. 健壮性
   - 监控中心宕机后不影响使用 只是会丢失部分的采样数据
   - 注册中心对等集群 任意一台宕机后  自动切换到另一台
   - 服务提供者无状态  任意一台宕机不影响使用 可以切换到另一台使用
3. 伸缩性
   - 注册中心对等集群  新部署的实例  客户端客户端 可以自动发现
   - 服务提供者无状态  可以动态增加提供者（然后它自己注册到注册中心）  注册中心可以推送给消费者



### 5.Dubbo 集群容错

![1544685138661](C:\Users\ADMINI~1\AppData\Local\Temp\1544685138661.png)



- 集群容错的缺省策略是 Failover
- Invoker 是 provider 的一个可用的服务的抽象  它封装了 provider的调用地址以及接口信息

### 6. 负载均衡策略

1. 随机负载均衡（random） 它可以根据权重来随机  **这个是默认轮训策略**

2. 轮训负载均衡（roundrobin）  它存在慢的提供者累计请求的问题

3. 最少活跃数负载均衡（leastactive）请求处理越慢的机器 被分配到请求数越少

4. 一致性hash 负载均衡（consistent hash）相同参数的请求总是会发到同一台机器上面

    

### 7.配置优先级

1. 方法级别>接口级别>全局配置
2. 同级别下 消费端的优先级 要高于提供方端
   - 一般cluster  配置在消费端  由消费端来选取我目前采取的集群策略
   - 像超时（timeout） 重试次数（retries）配置在提供端  因为提供端是最清楚一个服务需要调用多长时间的

### 8.服务降级

![1545035584779](C:\Users\ADMINI~1\AppData\Local\Temp\1545035584779.png)

**当提供方的服务不可用时 或者超时 客户端就会调用mock 的方法  注意的是 mock里面实现的接口要和原先调用的服务方实现的接口一致，而且建议写在消费端**



### 9.SPI 机制

![1545040689056](C:\Users\ADMINI~1\AppData\Local\Temp\1545040689056.png)

``` SPI是一种java内置的一种服务发现机制，他利用 ServiceLoader.load 去加载META-INF/services/接口全限定名 这样一个文件，文件的内容为实现该接口的实现类``` 

**Dubbo 的SPI机制稍微有点不一样 主要区别为以下两点：**

1. Dubbo 它不仅仅加载 META-INF/service 目录下的内容  它还要加载 META-INF/dubbo 和 META-INF/dubbo/internal 下的内容

2. Dubbo 加载文件里面内容格式也不一样  它是 key=value 的形式 

3. Dubbo 采用以下的方式来调用的和加载的 

   ```java
   ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension()
   ```

### 10.Dubbo 标签对在spring的扩展

1. 在META-INF/spring.handlers做如下定义：

   ```http\://dubbo.apache.org/schema/dubbo
      http\://dubbo.apache.org/schema/dubbo
      =org.apache.dubbo.config.spring.schema.DubboNamespaceHandler
   ```

   ```DubboNamespaceHandler```要继承```NamespaceHandlerSupport```  同时这个类里面还用到```DubboBeanDefinitionParser```  这个类主要是解析属性 并进行注册的 这个类要实现```BeanDefinitionParser```

1. 在META-INF/spring.schemes做如下定义：

​       ```http\://dubbo.apache.org/schema/dubbo/dubbo.xsd=META-INF/dubbo.xsd```

