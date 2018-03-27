package com.xue.design.dan_li;

/**
 * 单例模式 -> 懒汉模式
 *
 * @Author xueshun
 * @Create 2018-03-27 10:23
 */
public class Demo01 {

    //声明变量
    private static volatile Demo01 demo = null;

    public Demo01() {
    }

    public static Demo01 getInstance() {
        if (demo == null) {
            synchronized (Demo01.class) {
                if (demo == null) {
                    demo = new Demo01();
                }
            }
        }
        return demo;
    }
}
