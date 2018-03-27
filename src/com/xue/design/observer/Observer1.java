package com.xue.design.observer;

/**
 * @Author xueshun
 * @Create 2018-03-27 13:44
 */
public class Observer1 implements Observer{
    @Override
    public void update() {
        System.out.println("observer1 has received");
    }
}
