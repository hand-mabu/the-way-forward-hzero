# HZero框架学习

> 任务如下

1. 完成商品秒杀项目前后端(条件如下)
    1. 后端
        1. 完成相关逻辑搭建
        2. 完成相关数据库搭建
    2. 前端(包含逻辑)
        1. 至少有一个商品(包含图片)、倒计时器、库存显示
        2. 有一个秒杀按钮，计时器未到之前灰掉
        3. 有一个界面可以看到秒杀到的人
        4. 秒杀成功和失败需要显示提示
2. 将代码提交至github
3. 加分项
    1. 使用MQ消息 -> 每个提交为一个消息
    2. 使用Redis -> 通过key控制库存或其他
    3. 使用限流控制(比如接口1秒内只被允许访问10次，其余返回continue或者排队)
    4. 前端界面美观
    5. 秒杀成功需要付款(模拟就行)，1min未付款可以继续抢(库存+1)

> 请大家按照如下规范提交代码

1. 在各自名字下提交相关代码
2. 搭建起微服务框架(HZero中所有使用到的服务全部提交，前端不需要上传，演示即可)
3. 项目规范参考 [MABUDoc](https://hand-mabu.github.io/mabu-code-guide/)
4. 切勿照搬照抄，要有自己的理解 ^^

> 学习参考

- [HZero](http://hzero.saas.hand-china.com)
- [Java高并发秒杀API之业务分析与DAO层](http://www.imooc.com/learn/587)
- [Java高并发秒杀API之Service层](http://www.imooc.com/learn/631)
- [Java高并发秒杀API之web层](http://www.imooc.com/learn/630)
- [Java高并发秒杀API之高并发优化](http://www.imooc.com/learn/632)
- [基于 SpringBoot+Mybatis+Redis+RabbitMQ 秒杀系统](https://blog.csdn.net/qq_33524158/article/details/81675011)