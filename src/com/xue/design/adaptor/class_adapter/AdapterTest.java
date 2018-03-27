package com.xue.design.adaptor.class_adapter;

/**
 * @Author xueshun
 * @Create 2018-03-27 11:29
 */
public class AdapterTest {

    public static void main(String[] args) {
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }
}
