package com.xue.design.dan_li;

/**
 * 单例模式 饿汉模式
 * @Author xueshun
 * @Create 2018-03-27 10:21
 */
public class Demo {

    //直接创建对象
    public static Demo instance = new Demo();

    //私有化构造函数
    public Demo() {
    }

    //返回实例对象
    public static Demo getInstance() {
        return instance;
    }
}
