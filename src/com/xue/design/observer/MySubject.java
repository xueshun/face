package com.xue.design.observer;

/**
 * @Author xueshun
 * @Create 2018-03-27 13:51
 */
public class MySubject extends AbstractSubject{
    @Override
    public void operation() {
        System.out.println("update self");
        notifyObservers();
    }
}
