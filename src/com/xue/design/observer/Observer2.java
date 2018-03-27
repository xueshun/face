package com.xue.design.observer;

/**
 * @Author xueshun
 * @Create 2018-03-27 13:45
 */
public class Observer2 implements Observer{
    @Override
    public void update() {
        System.out.println("observer2 has received");
    }
}
