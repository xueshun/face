package com.xue.design.adaptor.class_adapter;

/**
 * @Author xueshun
 * @Create 2018-03-27 11:28
 */
public class Adapter extends Source implements  Targetable{
    @Override
    public void method2() {
        System.out.println("this is the targetable method");
    }
}
